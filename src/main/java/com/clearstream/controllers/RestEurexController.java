package com.clearstream.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restsvc")
public class RestEurexController {
    @GetMapping(path = "/eurex", produces = MediaType.APPLICATION_JSON_VALUE)
    //@RequestMapping("/eurex")
    public String showEurex() {
        return  "<Eurex/>";
    }
}
