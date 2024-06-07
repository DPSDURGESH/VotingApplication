//package com.voting.application.util;
//
//
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.voting.application.model.UserRegistration;
//import com.voting.application.repository.UserRepository;
//
//
//@Component
//public class Scheduler {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Scheduled(cron = "0 * * * * ?") // Run every minute
//	public void scheduleTask() {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
//		String strDate = dateFormat.format(new Date());
//		System.out.println("Cron job Scheduler: Job running at - " + strDate);
//
//		List<UserRegistration> lockedUserRegistration = userRepository.findByAccountStatus("LOCKED");
//
//		for (UserRegistration userRegistration : lockedUserRegistration) {
//
//			userRegistration.setAccountStatus("UNLOCK");
//			userRegistration.setLoginAttempts(0);
//			userRegistration.setLockedDateTime(null);
//			userRepository.save(userRegistration);
//
//			sendSMS(userRegistration.getEmail(), "Your account has been unlocked. Please login.");
//		}
//	}
//
//	private void sendSMS(String mobile, String message) {
//		System.out.println("Sending SMS to " + mobile + ": " + message);
//	}
//}
