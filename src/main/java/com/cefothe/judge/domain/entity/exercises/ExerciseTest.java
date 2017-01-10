package com.cefothe.judge.domain.entity.exercises;

import com.cefothe.judge.domain.entity.common.EntityAdapter;

import javax.persistence.*;

/**
 * Created by cefothe on 10.01.17.
 */
@Entity
@Table(name =  "exercise_test")
public class ExerciseTest extends EntityAdapter {

    @ManyToOne
    @JoinColumn(name="exercise_id", nullable=false)
    private Exercise exercise;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String input;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String output;

    protected  ExerciseTest(){

    }

    public ExerciseTest(Exercise exercise, String input, String output) {
        this.exercise = exercise;
        this.input = input;
        this.output = output;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
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
