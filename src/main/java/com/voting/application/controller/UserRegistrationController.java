package com.voting.application.controller;

import com.voting.application.model.UserRegistration;
import com.voting.application.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserRegistrationController {

	@Autowired
	private final UserRegistrationService userRegistrationService;

	public UserRegistrationController(UserRegistrationService userRegistrationService) {
		this.userRegistrationService = userRegistrationService;

	}

//	@GetMapping("/home")
//	public String homepage() {
//		return "home";
//	}
//
//	 @GetMapping("/signup")
//	    public String showSignUpForm(Model model) {
//	        model.addAttribute("userRegistration", new UserRegistration());
//	        return "signup"; // Ensure this matches the name of your Thymeleaf template file without.html
//	    }


	// Method to create a new user
	@PostMapping("/signup")
	public ResponseEntity<UserRegistration> createUser(@RequestBody UserRegistration userRegistration) {
		List<String> errors = userRegistrationService.validate(userRegistration);
		if (!errors.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		UserRegistration savedUser = userRegistrationService.saveUser(userRegistration);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	// Method to retrieve a user by ID
	@GetMapping("/{id}")
	public ResponseEntity<UserRegistration> getUserById(@PathVariable Long id) {

		// Validate the token

		Optional<UserRegistration> userRegistration = userRegistrationService.findUserById(id);
		return userRegistration.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	// Method to retrieve all users
	@GetMapping
	public ResponseEntity<List<UserRegistration>> getAllUsers() {
		List<UserRegistration> userRegistrations = userRegistrationService.findAllUsers();
		return new ResponseEntity<>(userRegistrations, HttpStatus.OK);
	}

	// Method to update a user
	@PutMapping("/{id}")
	public ResponseEntity<UserRegistration> updateUser(@PathVariable Long id,
			@RequestBody UserRegistration userDetails) {
		Optional<UserRegistration> userRegistration = userRegistrationService.findUserById(id);
		if (!userRegistration.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userRegistration.get().setEmail(userDetails.getEmail());
		userRegistration.get().setUsername(userDetails.getUsername());
		userRegistration.get().setPassword(userDetails.getPassword());
		UserRegistration updatedUser = userRegistrationService.saveUser(userRegistration.get());
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	// Method to delete a user by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userRegistrationService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	 // Method to retrieve all users with pagination
    @GetMapping("/pageable")
    public ResponseEntity<Page<UserRegistration>> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserRegistration> userRegistrations = userRegistrationService.findAllUsers(pageable);
        return new ResponseEntity<>(userRegistrations, HttpStatus.OK);
    }
	
	
	
 // Method to retrieve users within a specific range
    @GetMapping("/range")
    public ResponseEntity<Page<UserRegistration>> getUsersByRange(@RequestParam int start,
                                                                   @RequestParam int end) {
        Page<UserRegistration> userRegistrations = userRegistrationService.findUsersByRange(start, end);
        return new ResponseEntity<>(userRegistrations, HttpStatus.OK);
    }
	
	
	
	
	
	

	/*
	 * @GetMapping("/login") public String login() { return "login"; }
	 */

}
