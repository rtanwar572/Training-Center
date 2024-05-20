package com.trainingCenter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "centers")
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    @NotNull
    @Size(max = 40)
    private String centerName;

    @Column(nullable = false, unique = true, length = 12)
    @NotNull
    @Size(min = 12, max = 12)
    private String centerCode;

    @Embedded
    private Address address;

    private int studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    @Column(nullable = false)
    private Instant createdOn;

    @Email
    private String contactEmail;

    @NotNull
    @Pattern(regexp = "^\\d{10}$")
    private String contactPhone;

}


