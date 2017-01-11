package com.cefothe.judge.domain.dto;


import java.io.Serializable;
import java.util.List;

/**
 * Created by cefothe on 10.01.17.
 */
public class ExcerciseTO implements Serializable {

    public Long exerciseId;

    public String exerciseName;

    public String conditionTask;

    public List<ExerciseTestTO>  exerciseTest;

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getConditionTask() {
        return conditionTask;
    }

    public void setConditionTask(String conditionTask) {
        this.conditionTask = conditionTask;
    }

    public List<ExerciseTestTO> getExerciseTest() {
        return exerciseTest;
    }

    public void setExerciseTest(List<ExerciseTestTO> exerciseTest) {
        this.exerciseTest = exerciseTest;
    }
}
