package com.cefothe.judge.domain.entity.exercises;

import com.cefothe.judge.domain.entity.common.EntityAdapter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by cefothe on 10.01.17.
 */
@Entity
@Table(name = "exercise")
public class Exercise extends EntityAdapter{

    @Column(nullable = false)
    private String exerciseName;

    @Column(columnDefinition = "TEXT", name = "condition_task", nullable = false)
    private String conditionTask;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "exercise")
    private List<ExerciseTest> exerciseTest;

    protected Exercise(){

    }

    public Exercise(String exerciseName, String conditionTask, List<ExerciseTest> exerciseTest) {
        this.exerciseName = exerciseName;
        this.conditionTask = conditionTask;
        this.exerciseTest = exerciseTest;
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

    public List<ExerciseTest> getExerciseTest() {
        return exerciseTest;
    }

    public void setExerciseTest(List<ExerciseTest> exerciseTest) {
        this.exerciseTest = exerciseTest;
    }
}
