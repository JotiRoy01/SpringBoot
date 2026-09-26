package com.joti.interceptor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.service.registry.ImportHttpServices;

@Controller
@RequestMapping("api/students")
public class Studentcontroller {

    @PostMapping
    public ResponseEntity<String> createStudent(){
        System.out.println("controller Called");
        return ResponseEntity.ok("Student Created");
    }

}
