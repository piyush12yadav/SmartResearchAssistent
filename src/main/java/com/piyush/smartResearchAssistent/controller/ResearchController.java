package com.piyush.smartResearchAssistent.controller;


import com.piyush.smartResearchAssistent.entity.ResearchRequest;
import com.piyush.smartResearchAssistent.service.ResearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/research")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ResearchController {

    private final ResearchService researchService;

    @PostMapping("/process")
    public ResponseEntity<String> processContent(@RequestBody ResearchRequest request){

        String result = researchService.processContent(request);
        return ResponseEntity.ok(result);
    }
}
