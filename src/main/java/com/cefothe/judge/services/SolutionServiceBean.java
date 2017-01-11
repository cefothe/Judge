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
        String fileName = UUID.randomUUID().toString() +"." + solution.getProgramLanguage().getExtension();
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
    public void execute(SolutionTO solutionTO) throws IOException {
        Solution solution = convertTO(solutionTO);
        saveFileOnFileSystem(solution);
        saveOnDatabase(solution);
    }

    private Solution convertTO(SolutionTO solutionTO){
        PropertyMap<SolutionTO, Solution> orderMap = new PropertyMap<SolutionTO, Solution>() {
            protected void configure() {
                map().setCode(source.getCode());
                map().setProgramLanguage(source.getProgramLanguage());
            }
        };
        Solution solution = modelParser.convert(solutionTO, Solution.class,orderMap);
        solution.setExercise(exerciseRepository.findOne(solutionTO.getExcerciseId()));
        return solution;
    }
}
