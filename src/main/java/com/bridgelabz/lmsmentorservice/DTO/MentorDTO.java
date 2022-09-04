package com.bridgelabz.lmsmentorservice.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString
public class MentorDTO {
    private String employeeId;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Invalid FirstName...!")
    private String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Invalid LastName...!")
    private String lastName;
    @NotNull(message = "Mentor type Should not be null")
    private String mentorType;
    @NotNull(message = "Mentor role should not be null")
    private String mentorRole;
    @Pattern(regexp = "^[6789][0-9]{9}$")
    private String mobileNum;
    @NotNull(message = "Email should not be null")
    private String email;
    @NotNull(message = "Experience year should not be null")
    private String experienceYear;
    @NotNull(message = "Preferred Time should not be null")
    private String preferredTime;
    @NotNull(message = "Start date Should not be null")
    private LocalDate startDate;
    @NotNull(message = "Status should not be null")
    private String status;
    private String mentorDescription;
    private String profileImageUrl;
    private int creatorUser;
    private long supervisor;
    private LocalDateTime createdTimeStamp;
    private LocalDateTime updatedTimeStamp;

}
