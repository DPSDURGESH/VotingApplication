//package com.voting.application.controller;
//
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.voting.application.repository.CandidateRepository;
//import com.voting.application.service.VoteServices;
//
//@Controller
//public class FinalVoteCount {
//
//    @Autowired
//    CandidateRepository candidateRepository;
//    
//    @Autowired
//    VoteServices voteServices;
//    
//    
////    @GetMapping("/votecounts")
////    public String showVoteCount() {
////        // No need to add attributes here unless you want to pre-populate the form
////        return "votecounts"; // Name of your Thymeleaf template
////    }
//    
//    
//
//    @GetMapping("/votecounts")
//    public String getCandidateVoteCounts(Model model)
//    {    
//    	Map<String, Integer> voteCounts = voteServices.getVoteCounts();
//    	model.addAttribute("voteCounts",voteCounts);
//    	
//        return "votecounts";
//        
//    }
//    
//    
//}
