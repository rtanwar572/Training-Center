package com.trainingCenter.service;

import com.trainingCenter.exception.ResourceNotFoundException;
import com.trainingCenter.model.TrainingCenter;
import com.trainingCenter.repo.ITrainingCenterRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainingCenterService {

    @Autowired
    private ITrainingCenterRepo repo;

    public TrainingCenter saveTrainingCenter(TrainingCenter center) {
        center.setCreatedOn(Instant.now());
        center.setCenterName(center.getCenterName().toUpperCase());
        return repo.save(center);
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        return repo.findAll();
    }

    public Boolean getTrainingCenter(TrainingCenter center) {
        TrainingCenter alreadyPresentCent = repo.findByCenterName(center.getCenterName().toUpperCase());
        if (alreadyPresentCent != null) {
            return true;
        }
        return false;
    }

    public TrainingCenter updateCenterName(Long id, String newCenterName) {
        TrainingCenter center = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Training Center Is Not found"));
        center.setCenterName(newCenterName);
        return repo.save(center);
    }


    public TrainingCenter getTrainingCenterById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Training Center Is Not found"));
    }


    public Boolean fingTrainingCenterById(Long id) {

        if(repo.existsById(id)){
            return true;
        }
        return false;
    }

    public void deleteCenterByid(Long id) {
        repo.deleteById(id);
    }

    public List<TrainingCenter> getFilteredTrainingCenters(Optional<String> centerName, Optional<String> centerCode, Optional<String> course) {
        List<TrainingCenter> centers = repo.findAll();

        return centers.stream()
                .filter(center -> centerName.map(name -> center.getCenterName().contains(name)).orElse(true))
                .filter(center -> centerCode.map(code -> center.getCenterCode().equals(code)).orElse(true))
                .filter(center -> course.map(c -> List.of(center.getCoursesOffered()).contains(c)).orElse(true))
                .collect(Collectors.toList());
    }
}

