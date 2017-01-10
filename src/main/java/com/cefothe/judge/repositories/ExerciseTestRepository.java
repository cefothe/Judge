package com.cefothe.judge.repositories;

import com.cefothe.judge.domain.entity.exercises.ExerciseTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cefothe on 10.01.17.
 */
@Repository
public interface ExerciseTestRepository extends JpaRepository<ExerciseTest, Long> {
}
