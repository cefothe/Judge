package com.cefothe.judge.domain.entity.solution;

import com.cefothe.judge.common.ProgramLanguages;
import com.cefothe.judge.domain.entity.common.EntityAdapter;
import com.cefothe.judge.domain.entity.exercises.Exercise;

import javax.persistence.*;

/**
 * Created by cefothe on 11.01.17.
 */
@Entity
@Table(name = "solution")
public class Solution extends EntityAdapter {

    @ManyToOne
    @JoinColumn(name="exercise_id", nullable=false)
    public Exercise exercise;

    @Column(columnDefinition = "BLOB")
    public String code;

    @Enumerated(EnumType.STRING)
    @Column(name= "program_language")
    public ProgramLanguages programLanguage;

    public Solution(Exercise exercise, String code, ProgramLanguages programLanguage) {
        this.exercise = exercise;
        this.code = code;
        this.programLanguage = programLanguage;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
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
