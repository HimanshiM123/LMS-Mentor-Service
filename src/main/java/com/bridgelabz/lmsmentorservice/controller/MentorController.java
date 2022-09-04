package com.bridgelabz.lmsmentorservice.controller;

import com.bridgelabz.lmsmentorservice.DTO.MentorDTO;
import com.bridgelabz.lmsmentorservice.service.IMentorService;
import com.bridgelabz.lmsmentorservice.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/*
      Purpose : MentorController to process Data API's
      @author : Himanshi Mohabe
      version : 1.0
     */

@RestController
@RequestMapping("/mentor")
public class MentorController {
    @Autowired
    IMentorService mentorService;

    /*
     *@Purpose:to add Mentor details into the Mentor Repository
     * @Param : AdminDTO, Token
     */

    @PostMapping(value = "/addMentor")
    ResponseEntity<Response> addMentorData(@Valid @RequestBody MentorDTO mentorDTO, @RequestHeader String token) {
        Response response = mentorService.addMentor(mentorDTO, token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

     /*
     *@Purpose : to get list of Mentor details in the mentor Repository using id
      @Param  : id
     */

    @GetMapping("/getMentor/{id}")
    ResponseEntity<Response> getMentor(@PathVariable long id){
        Response response = mentorService.getMentorById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
    *@Purpose : Ability to get list of Mentor details in the Mentor Repository
     @Param : token
    */

    @GetMapping("/getMentor")
    ResponseEntity<Response> getAllMentor(@RequestHeader String token){
        Response response = mentorService.getAllMentorData(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
     @Purpose : Able to update Mentor details into the Mentor Repository
     @Param : AdminDTO, id and token
     */

    @PutMapping("updateMentor/{id}")
    ResponseEntity<Response> updateMentor(@Valid @RequestBody MentorDTO mentorDTO, @PathVariable long id, @RequestHeader String token ){
        Response response = mentorService.updateMentor(id, mentorDTO, token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

     /*
      @Purpose : Able to delete  Mentor details  in the mentor Repository
      @Param : token and id
     */

    @DeleteMapping("deleteMentor/{id}")
    ResponseEntity<Response> deleteMentor(@PathVariable Long id, @RequestHeader String token){

        Response response = mentorService.deleteMentor(id, token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
