package com.cefothe.judge.services;

import com.cefothe.judge.common.ProgramLanguages;
import com.cefothe.judge.compilers.Compiler;
import com.cefothe.judge.configuration.Configuration;
import com.cefothe.judge.domain.dto.ExerciseTestTO;
import com.cefothe.judge.domain.dto.SolutionTO;
import com.cefothe.judge.domain.entity.exercises.ExerciseTest;
import com.cefothe.judge.domain.entity.solution.Solution;
import com.cefothe.judge.io.interfaces.FileIO;
import com.cefothe.judge.parse.ModelParser;
import com.cefothe.judge.repositories.ExerciseRepository;
import com.cefothe.judge.repositories.SolutionRepository;
import org.apache.log4j.Logger;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by cefothe on 11.01.17.
 */
@Service
public class SolutionServiceBean implements SolutionService {

    private static final Logger LOG = Logger.getLogger(SolutionService.class);

    @Autowired
    private ModelParser modelParser;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private FileIO fileIO;

    @Autowired
    private SolutionRepository solutionRepository;

    @Override
    public String saveFileOnFileSystem(Solution solution) throws IOException {
        String fileName = "Main" +"." + solution.getProgramLanguage().getExtension();
        try {
            fileIO.write(solution.getCode(), Configuration.SAVE_FILE_DIRECTORY,fileName);
        } catch (IOException e) {
            LOG.warn("Can't save file related to solution id "+solution.getId());
            throw  e;
        }
        return  fileName;
    }

    @Override
    public void saveOnDatabase(Solution solution) {
        solutionRepository.saveAndFlush(solution);
    }

    @Override
    public void compile(String directory, String className , ProgramLanguages programLanguage) throws IOException {
        Compiler compiler = programLanguage.compiler();
        compiler.compile(directory, className);
    }

    @Override
    public List<String> executor(String directory, String classNam, List<String> params) {
        return null;
    }

    @Override
    public void execute(SolutionTO solutionTO) throws IOException {
        Solution solution = convertTO(solutionTO);
        String fileName = saveFileOnFileSystem(solution);
        saveOnDatabase(solution);
        compile(Configuration.SAVE_FILE_DIRECTORY,fileName,solution.getProgramLanguage());
    }

    private Solution convertTO(SolutionTO solutionTO){
        return  new Solution(exerciseRepository.findOne(solutionTO.getExcerciseId()),solutionTO.getCode(),solutionTO.getProgramLanguage());
    }
}
