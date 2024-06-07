package com.voting.application.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voting.application.model.Candidate;
import com.voting.application.model.Vote;

// In VoteRepository.java
public interface VoteRepository extends JpaRepository<Vote, Long> {
    
	void save(Candidate candidate);

	Optional<Vote> findById(Long userId);
}
