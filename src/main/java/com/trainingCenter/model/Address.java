package com.trainingCenter.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
        @NotNull
        @NotEmpty
        private String detailedAddress;
        private String city;
        private String state;
        private String pincode;

        // Getters and Setters
}
