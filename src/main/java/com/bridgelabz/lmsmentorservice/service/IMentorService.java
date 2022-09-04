package com.bridgelabz.lmsmentorservice.service;

import com.bridgelabz.lmsmentorservice.DTO.MentorDTO;
import com.bridgelabz.lmsmentorservice.model.MentorModel;
import com.bridgelabz.lmsmentorservice.util.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMentorService {

    Response addMentor(MentorDTO mentorDTO, String token);

    Response getMentorById(long id);

    Response getAllMentorData(String token);

    Response updateMentor(long id, MentorDTO mentorDTO, String token);

    Response deleteMentor(Long id, String token);
}
