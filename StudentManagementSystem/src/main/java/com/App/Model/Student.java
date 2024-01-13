package com.App.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String firstname;
private String lastname;
private String imagename;
private String mobilenumber;
private String email;
private String password;
@Enumerated(EnumType.STRING)
private Role role;
@JsonManagedReference
@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
@JoinColumn(name="address_id")
private Address address;

@JsonBackReference
@ManyToOne
(cascade=CascadeType.ALL)
@JoinColumn(name="course_id")
private Course course;
@OneToOne(mappedBy = "student")
private Payment payment;
private int ispurchased=0;
//this is our non owning side 
//non owning means its doesn't contain any foreign key
public Student(String firstname, String lastname, String imagename, String mobilenumber, String email, String password,
		Role role) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.imagename = imagename;
	this.mobilenumber = mobilenumber;
	this.email = email;
	this.password = password;
	
	this.role = role;
}

}