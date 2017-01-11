package com.cefothe.judge.services;

import com.cefothe.judge.common.ProgramLanguages;
import com.cefothe.judge.domain.dto.SolutionTO;
import com.cefothe.judge.domain.entity.solution.Solution;

import java.io.File;
import java.io.IOException;

/**
 * Created by cefothe on 11.01.17.
 */
public interface SolutionService {
    String saveFileOnFileSystem(Solution solution) throws IOException;
    void saveOnDatabase(Solution solution);
    void compile(String directory, String className, ProgramLanguages programLanguage) throws IOException;

    void execute(SolutionTO solutionTO) throws IOException;
}
