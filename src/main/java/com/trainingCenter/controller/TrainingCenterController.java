package com.trainingCenter.controller;

import com.trainingCenter.exception.ResourceNotFoundException;
import com.trainingCenter.model.TrainingCenter;
import com.trainingCenter.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/training-centers")
@Validated

public class TrainingCenterController {

    @Autowired
    private TrainingCenterService service;

//    Create Training Center
    @PostMapping
    public ResponseEntity<Map<String, Object>> createTrainingCenter(@Valid @RequestBody TrainingCenter center) {
        Boolean isCenterPresent = service.getTrainingCenter(center);
        Map<String, Object> response = new HashMap<>();
        if(isCenterPresent == false){
            TrainingCenter savedCenter = service.saveTrainingCenter(center);
            response.put("message", "Training Center created successfully");
            response.put("data", savedCenter);
        }
        response.put("message: ","Training Center is Already Present");
        return ResponseEntity.status(201).body(response);
    }

//    Get all Training Centers
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllTrainingCenters(
            @RequestParam Optional<String> centerName,
            @RequestParam Optional<String> centerCode,
            @RequestParam Optional<String> course) {

        List<TrainingCenter> centers = service.getFilteredTrainingCenters(centerName, centerCode, course);
        Map<String, Object> response = new HashMap<>();
        response.put("message", centers.isEmpty() ? "No training centers found" : "Training centers retrieved successfully");
        response.put("data", centers);
        return ResponseEntity.ok(response);
    }

    //Get center By Id
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getTrainingCenterById(@PathVariable Long id) {
        TrainingCenter center = service.getTrainingCenterById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Training Center retrieved successfully");
        response.put("data", center);
        return ResponseEntity.ok(response);
    }

    //update centerName By Id
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateCenterNameById(@PathVariable Long id, @RequestBody TrainingCenter updates) {
        String newCenterName = updates.getCenterName();
        if (newCenterName == null || newCenterName.isEmpty()) {
            throw new IllegalArgumentException("centerName must not be null or empty");
        }

        TrainingCenter updatedCenter = service.updateCenterName(id, newCenterName);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Training Center name updated successfully");
        response.put("data", updatedCenter);
        return ResponseEntity.ok(response);
    }

    //delete center By Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteTrainingCenterById(@PathVariable Long id) {
        Boolean isCenterPresent = service.fingTrainingCenterById(id);
        Map<String, String> response = new HashMap<>();
        if(isCenterPresent){
            service.deleteCenterByid(id);
            response.put("message", "Training Center deleted successfully");
            return ResponseEntity.ok(response);
        }
        response.put("message", "Training Center Not found");
        return ResponseEntity.status(404).body(response);

    }
}
