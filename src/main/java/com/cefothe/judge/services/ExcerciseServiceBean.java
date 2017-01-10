package com.cefothe.judge.services;

import com.cefothe.judge.domain.dto.ExcerciseTO;
import com.cefothe.judge.domain.entity.exercises.Exercise;
import com.cefothe.judge.parse.ModelParser;
import com.cefothe.judge.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cefothe on 10.01.17.
 */
@Service
public class ExcerciseServiceBean implements ExcerciseService {

    @Autowired
    private ModelParser modelParser;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public void create(ExcerciseTO excerciseTO) {
        Exercise excercise = modelParser.convert(excerciseTO, Exercise.class);
        exerciseRepository.saveAndFlush(excercise);
    }

    @Override
    public List<ExcerciseTO> getAll() {
        List<ExcerciseTO> listExcerciseTOs = new ArrayList<>();
        exerciseRepository.findAll().forEach(exercise -> {
            ExcerciseTO excerciseTO =modelParser.convert(exercise, ExcerciseTO.class);
            listExcerciseTOs.add(excerciseTO);
        });

        return  listExcerciseTOs;
    }
}
