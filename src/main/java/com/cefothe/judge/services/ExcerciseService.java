package com.cefothe.judge.services;

import com.cefothe.judge.domain.dto.ExcerciseTO;

import java.util.List;

/**
 * Created by cefothe on 10.01.17.
 */
public interface ExcerciseService {
     void create(ExcerciseTO excerciseTO);
     List<ExcerciseTO> getAll();

}
