package com.voting.application.model;

//import java.time.LocalDateTime;
//import java.util.Collection;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserRegistration { 	// implements UserDetails

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    
//    private String accountStatus; // "ACTIVE", "LOCKED"
//	private Integer loginAttempts;
//	private LocalDateTime lockedDateTime;

    // Getters and Setters
   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}

//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return false;
//	}

//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}

//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return false;
//	}

//	public String getAccountStatus() {
//		return accountStatus;
//	}

//	public Integer getLoginAttempts() {
//		return loginAttempts;
//	}

//	public LocalDateTime getLockedDateTime() {
//		return lockedDateTime;
//	}

	public void setId(Long id) {
		this.id = id;
	}

//	public void setAccountStatus(String accountStatus) {
//		this.accountStatus = accountStatus;
//	}
//
//	public void setLoginAttempts(Integer loginAttempts) {
//		this.loginAttempts = loginAttempts;
//	}
//
//	public void setLockedDateTime(LocalDateTime lockedDateTime) {
//		this.lockedDateTime = lockedDateTime;
//	}

	

	
}

