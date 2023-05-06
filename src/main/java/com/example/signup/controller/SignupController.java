package com.example.signup.controller;


import com.example.signup.Repo.SignupRepository;
import com.example.signup.dao.Signup;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class SignupController {

    Logger log = LoggerFactory.getLogger(SignupController.class);

    @Autowired
    SignupRepository signupRepo;

    @Autowired
    ObjectMapper map;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Signup signup) {
        log.info("got request to create user {}", signup);
        try {
            signupRepo.save(signup);
            return new ResponseEntity("OK", HttpStatus.OK);

        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
