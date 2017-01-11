package com.cefothe.judge.services;

import com.cefothe.judge.common.ProgramLanguages;
import com.cefothe.judge.domain.dto.SolutionTO;
import com.cefothe.judge.domain.entity.solution.Solution;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by cefothe on 11.01.17.
 */
public interface SolutionService {
    String saveFileOnFileSystem(Solution solution) throws IOException;
    void saveOnDatabase(Solution solution);
    void compile(String directory, String className, ProgramLanguages programLanguage) throws IOException;
    List<String> executor(String directory, String classNam, List<String> params);
    void execute(SolutionTO solutionTO) throws IOException;
}
