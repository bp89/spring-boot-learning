package com.craigecomputing.controller;

import com.craigecomputing.dtos.ProfileDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class HelloController {

    @RequestMapping("/")
    @ResponseBody
    public ProfileDto sayHello(){

        return ProfileDto.builder()
                .name("We need to secure ourselves!")
                .build();
    }
}
