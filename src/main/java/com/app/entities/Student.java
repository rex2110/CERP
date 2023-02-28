package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "password")
public class Student extends BaseEntity{
	@Column(length = 20)
	@NotBlank(message = "First Name is required!!")
	@Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters")
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 30,unique = true)
	@NotBlank(message = "Email id is required")
	@Email(message = "Invalid Email address")
	private String email;
	@Column(length = 20,nullable = false)
	@NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password should have at least 6 characters")
	@JsonProperty(access = Access.WRITE_ONLY)
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{6,20})",message = "Invalid Password!")
	private String password;
	@Column(length=50)
	private String address;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;

	public Student(
			@NotBlank(message = "First Name is required!!") @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters") String firstName,
			String lastName,
			@NotBlank(message = "Email id is required") @Email(message = "Invalid Email address") String email,
			@NotBlank(message = "Password is required") @Size(min = 6, message = "Password should have at least 6 characters") @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{6,20})", message = "Invalid Password!") String password,
			String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
	}	
	
	
}
