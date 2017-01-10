package com.cefothe.judge.rest;

import com.cefothe.judge.domain.dto.ExcerciseTO;
import com.cefothe.judge.domain.dto.ExerciseTestTO;
import com.cefothe.judge.services.ExcerciseTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cefothe on 10.01.17.
 */
@RestController
@RequestMapping("/exercise/test")
public class ExcerciseTestController {

    @Autowired
    private ExcerciseTestService excerciseTestService;

    @PostMapping
    public void create(@RequestBody ExerciseTestTO excerciseTO) {
        excerciseTestService.create(excerciseTO);
    }
}
