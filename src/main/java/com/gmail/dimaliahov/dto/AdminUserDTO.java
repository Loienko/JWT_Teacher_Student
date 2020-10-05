package com.gmail.dimaliahov.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gmail.dimaliahov.model.Status;
import com.gmail.dimaliahov.model.User;
import lombok.Data;

@Data
@JsonIgnoreProperties (ignoreUnknown = true)
public class AdminUserDTO {
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String status;

	public static AdminUserDTO fromUser (User user) {
		AdminUserDTO adminUserDto = new AdminUserDTO();
		adminUserDto.setId(user.getId());
		adminUserDto.setUsername(user.getUsername());
		adminUserDto.setFirstName(user.getFirstName());
		adminUserDto.setLastName(user.getLastName());
		adminUserDto.setEmail(user.getEmail());
		adminUserDto.setStatus(user.getStatus().name());
		return adminUserDto;
	}

	public User toUser () {
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setStatus(Status.valueOf(status));
		return user;
	}

	@Override
	public String toString () {
		return "AdminUserDto{" +
				"id=" + id +
				", username='" + username + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}