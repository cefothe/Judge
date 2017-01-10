package com.cefothe.judge.rest;

import com.cefothe.judge.domain.dto.ExcerciseTO;
import com.cefothe.judge.services.ExcerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by cefothe on 10.01.17.
 */
@RestController
@RequestMapping("/exercise")
public class ExcerciseController {

    @Autowired
    private ExcerciseService excerciseService;

    @GetMapping("/all")
    public List<ExcerciseTO> getAll(){
        return  excerciseService.getAll();
    }

    @PostMapping
    public void create(@RequestBody ExcerciseTO excerciseTO) {
        excerciseService.create(excerciseTO);
    }
}
