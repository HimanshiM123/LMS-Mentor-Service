package com.bridgelabz.lmsmentorservice.repository;

import com.bridgelabz.lmsmentorservice.model.MentorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMentorRepository extends JpaRepository<MentorModel, Long> {
}
