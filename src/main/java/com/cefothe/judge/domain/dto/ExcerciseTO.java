package com.cefothe.judge.domain.dto;


import java.util.List;

/**
 * Created by cefothe on 10.01.17.
 */
public class ExcerciseTO {

    public Long exerciseId;

    public String exerciseName;

    public String conditionTask;

    public List<ExerciseTestTO>  exerciseTestTOs;
}
