package com.cefothe.judge.domain.dto;

/**
 * Created by cefothe on 10.01.17.
 */
public class ExerciseTestTO {

    public Long exerciseId;

    public Long exerciseTestId;

    public String input;

    public String output;

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Long getExerciseTestId() {
        return exerciseTestId;
    }

    public void setExerciseTestId(Long exerciseTestId) {
        this.exerciseTestId = exerciseTestId;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
