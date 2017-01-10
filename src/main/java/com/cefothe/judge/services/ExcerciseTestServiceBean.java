package com.cefothe.judge.services;

import com.cefothe.judge.domain.dto.ExcerciseTO;
import com.cefothe.judge.domain.dto.ExerciseTestTO;
import com.cefothe.judge.domain.entity.exercises.ExerciseTest;
import com.cefothe.judge.parse.ModelParser;
import com.cefothe.judge.repositories.ExerciseRepository;
import com.cefothe.judge.repositories.ExerciseTestRepository;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cefothe on 10.01.17.
 */
@Service
public class ExcerciseTestServiceBean implements  ExcerciseTestService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private ExerciseTestRepository exerciseTestRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public void create(ExerciseTestTO exerciseTestTO) {
        PropertyMap<ExerciseTestTO, ExerciseTest> orderMap = new PropertyMap<ExerciseTestTO, ExerciseTest>() {
            protected void configure() {
                map().setInput(source.getInput());
                map().setOutput(source.getOutput());

            }
        };
        ExerciseTest exerciseTest = modelParser.convert(exerciseTestTO, ExerciseTest.class,orderMap);
        exerciseTest.setExercise(exerciseRepository.findOne(exerciseTestTO.getExerciseId()));
        exerciseTestRepository.saveAndFlush(exerciseTest);
    }
}
