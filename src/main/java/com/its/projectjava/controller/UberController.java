package com.its.projectjava.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UberController {
    @GetMapping("/")
    public String getIndex(){
        return "homepage";
    }
    @GetMapping("/cpe")
    public String getCpet(){
        return "cpe";
    }
    @GetMapping("/homepage")
    public String getHomepage(){
        return "homepage";
    }
    @GetMapping("/profilstartup")
    public String getProfilStartup(){
        return "profilStartup";
    }
    @GetMapping("/whatwedo")
    public String getWhatWeDO(){
        return "whatWeDo";
    }
}
