package com.trainingCenter.repo;

import com.trainingCenter.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrainingCenterRepo extends JpaRepository<TrainingCenter, Long> {
    TrainingCenter findByCenterName(String centerName);
}
