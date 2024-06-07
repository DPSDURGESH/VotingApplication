package com.voting.application.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.voting.application.service.VoteServices;

@Controller
@RequestMapping
public class VoteController {

    private final VoteServices voteServices;

    public VoteController(VoteServices voteServices) {
        this.voteServices = voteServices;
    }
    
    
    @GetMapping("/vote")
    public String showVotingForm(Model model) {
        // No need to add attributes here unless you want to pre-populate the form
        return "vote"; // Name of your Thymeleaf template
    }
    

    @PostMapping("/vote")
    public ResponseEntity<String> castVote(@RequestBody Map<String, Object> requestBody) {
        Integer userIdInt = (Integer) requestBody.getOrDefault("id", null);
        String candidateName = (String) requestBody.getOrDefault("candidateName", null);

        if (userIdInt == null || candidateName == null) {
            return ResponseEntity.badRequest().body("Both 'id' and 'candidateName' are required.");
        }

        // Convert Integer to Long safely
        Long userId = userIdInt!= null? Long.valueOf(userIdInt) : null;

        try {
            System.out.println("Durgesh");
            voteServices.castVote(userId, candidateName);
            return ResponseEntity.ok("Vote cast successfully");
        }
        catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

}