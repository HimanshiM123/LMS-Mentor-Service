package com.bridgelabz.lmsmentorservice.service;

import com.bridgelabz.lmsmentorservice.DTO.MentorDTO;
import com.bridgelabz.lmsmentorservice.exception.AdminException;
import com.bridgelabz.lmsmentorservice.model.MentorModel;
import com.bridgelabz.lmsmentorservice.repository.IMentorRepository;
import com.bridgelabz.lmsmentorservice.util.Response;
import com.bridgelabz.lmsmentorservice.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MentorService implements IMentorService{
    @Autowired
    IMentorRepository mentorRepository;
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    MailService mailService;
    @Autowired
    RestTemplate restTemplate;

    @Override
   public Response addMentor(MentorDTO mentorDTO, String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8082/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            MentorModel mentorModel = new MentorModel(mentorDTO);
            mentorModel.setCreatedTimeStamp(LocalDateTime.now());
            mentorRepository.save(mentorModel);
            String body = "Mentor added Successfully with id  :" + mentorModel.getId();
            String subject = "Mentor added Successfully....";
            mailService.send(mentorModel.getEmail(), body, subject);
            return new Response("Mentor Added Successfully", 200, mentorModel);
        }
        throw new AdminException(400, "Token is Wrong");
    }

    @Override
    public Response getMentorById(long id) {
        Optional<MentorModel> mentorModel = mentorRepository.findById(id);
        return new Response("Mentor Added Successfully", 200, mentorModel);
    }

    @Override
    public Response getAllMentorData(String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8082/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Long mentorId = tokenUtil.decodeToken(token);
            Optional<MentorModel> isMentorPresent = mentorRepository.findById(mentorId);
            if (isMentorPresent.isPresent()) {
                List<MentorModel> getAllMentor = mentorRepository.findAll();
                if (getAllMentor.size() > 0)
                    return new Response("Mentor Added Successfully", 200, getAllMentor);
                else
                    throw new AdminException(400, "No Data Found");
            }
        }
        throw new AdminException(400, "Mentor not found");
    }

    @Override
   public Response updateMentor(long id, MentorDTO mentorDTO, String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8082/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Long mentorId = tokenUtil.decodeToken(token);
            Optional<MentorModel> isMentorPresent = mentorRepository.findById(mentorId);
            if (isMentorPresent.isPresent()) {
                isMentorPresent.get().setEmployeeId(mentorDTO.getEmployeeId());
                isMentorPresent.get().setFirstName(mentorDTO.getFirstName());
                isMentorPresent.get().setLastName(mentorDTO.getLastName());
                isMentorPresent.get().setMentorType(mentorDTO.getMentorType());
                isMentorPresent.get().setMobileNum(mentorDTO.getMobileNum());
                isMentorPresent.get().setEmail(mentorDTO.getEmail());
                isMentorPresent.get().setExperienceYear(mentorDTO.getExperienceYear());
                isMentorPresent.get().setPreferredTime(mentorDTO.getPreferredTime());
                isMentorPresent.get().setStartDate(mentorDTO.getStartDate());
                isMentorPresent.get().setStatus(mentorDTO.getStatus());
                isMentorPresent.get().setMentorDescription(mentorDTO.getMentorDescription());
                isMentorPresent.get().setProfileImageUrl(mentorDTO.getProfileImageUrl());
                isMentorPresent.get().setCreatorUser(mentorDTO.getCreatorUser());
                isMentorPresent.get().setSupervisor(mentorDTO.getSupervisor());
                isMentorPresent.get().setCreatedTimeStamp(mentorDTO.getCreatedTimeStamp());
                isMentorPresent.get().setUpdatedTimeStamp(mentorDTO.getUpdatedTimeStamp());
                String body = "Mentor updated Successfully with id  :" + isMentorPresent.get().getId();
                String subject = "Mentor updated Successfully....";
                mailService.send(isMentorPresent.get().getEmail(), body, subject);
                return new Response("Mentor Added Successfully", 200, isMentorPresent);
            }
        }
        throw  new AdminException(400, "Mentor not Present");
    }

    @Override
   public Response deleteMentor(Long id, String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8082/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Long mentorId = tokenUtil.decodeToken(token);
            Optional<MentorModel> isMentorPresent = mentorRepository.findById(mentorId);
            if (isMentorPresent.isPresent()) {
                mentorRepository.delete(isMentorPresent.get());
                return new Response("Mentor Added Successfully", 200, isMentorPresent);
            }
        }
        throw new AdminException(400, "Mentor Not found");
    }
}
