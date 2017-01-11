package com.cefothe.judge.repositories;

import com.cefothe.judge.domain.entity.exercises.ExerciseTest;
import com.cefothe.judge.domain.entity.solution.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cefothe on 11.01.17.
 */
@Repository
public interface SolutionRepository extends JpaRepository<Solution, Long> {
}
