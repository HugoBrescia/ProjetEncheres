package fr.eni.projetEnchereHugo.controller;

import fr.eni.projetEnchereHugo.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/sample")
    public String getSampleResource() {
        throw new ResourceNotFoundException("Resource not found");
    }
}
