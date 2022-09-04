package com.bridgelabz.lmsmentorservice.model;

import com.bridgelabz.lmsmentorservice.DTO.MentorDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "mentor")
@Data
public class MentorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employeeId;
    private String firstName;
    private String lastName;
    private String mentorType;
    private String mentorRole;
    private String mobileNum;
    private String email;
    private String experienceYear;
    private String preferredTime;
    private LocalDate startDate;
    private String status;
    private String mentorDescription;
    private String profileImageUrl;
    private int creatorUser;
    private long supervisor;
    private LocalDateTime createdTimeStamp;
    private LocalDateTime updatedTimeStamp;

    public MentorModel(MentorDTO mentorDTO) {
        this.employeeId = mentorDTO.getEmployeeId();
        this.firstName = mentorDTO.getFirstName();
        this.lastName = mentorDTO.getLastName();
        this.mentorType = mentorDTO.getMentorType();
        this.mentorRole = mentorDTO.getMentorRole();
        this.mobileNum = mentorDTO.getMobileNum();
        this.email = mentorDTO.getEmail();
        this.experienceYear = mentorDTO.getExperienceYear();
        this.preferredTime = mentorDTO.getPreferredTime();
        this.startDate = mentorDTO.getStartDate();
        this.status = mentorDTO.getStatus();
        this.mentorDescription = mentorDTO.getMentorDescription();
        this.profileImageUrl = mentorDTO.getProfileImageUrl();
        this.creatorUser = mentorDTO.getCreatorUser();
        this.supervisor = mentorDTO.getSupervisor();
        this.createdTimeStamp = mentorDTO.getCreatedTimeStamp();
        this.updatedTimeStamp = mentorDTO.getUpdatedTimeStamp();
    }

    public MentorModel() {

    }
}
