package com.springboot.hello.controller;

import com.springboot.hello.dao.HospitalDao;

import com.springboot.hello.domain.dto.Hospital;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hospital")
public class HospitalController {

    HospitalDao hospitalDao;

    public HospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @GetMapping("/hospitals/{id}")
    public Hospital findById(@PathVariable int id) {
        Hospital hospital = hospitalDao.findById(id);
        return hospital;
    }

}
