package com.cefothe.judge.domain.dto;

import com.cefothe.judge.common.ProgramLanguages;

import java.io.Serializable;

/**
 * Created by cefothe on 11.01.17.
 */
public class SolutionTO implements Serializable {

    public Long excerciseId;

    public String code;

    public ProgramLanguages programLanguage;

    public SolutionTO() {
    }

    public Long getExcerciseId() {
        return excerciseId;
    }

    public void setExcerciseId(Long excerciseId) {
        this.excerciseId = excerciseId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ProgramLanguages getProgramLanguage() {
        return programLanguage;
    }

    public void setProgramLanguage(ProgramLanguages programLanguage) {
        this.programLanguage = programLanguage;
    }
}
