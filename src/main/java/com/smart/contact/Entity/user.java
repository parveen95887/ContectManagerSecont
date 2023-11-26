package com.smart.contact.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
public class user implements Serializable {
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	@NotBlank(message="name field required")
	@NotNull(message="is not null")
	@NotEmpty(message=" name is not empty")
	@Size(min = 4,max = 20,message="name must greter than 4 and less than 20")
	@Pattern(regexp = "[A-Za-z]+" ,message="please enter valid name")
   private String name;
   @Override
public String toString() {
	return "user [id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass + ", about=" + about
			+ ", enabaled=" + enabaled + ", imgurl=" + imgurl +",role"+role +"]";
}
public user() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getAbout() {
	return about;
}
public void setAbout(String about) {
	this.about = about;
}
public boolean isEnabaled() {
	return enabaled;
}
public void setEnabaled(boolean enabaled) {
	this.enabaled = enabaled;
}
public String getImgurl() {
	return imgurl; 
}
public void setImgurl(String imgurl) {
	this.imgurl = imgurl;
}
@Column(unique = true)
@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email address")
@NotNull(message="Email field is required")
   private String email;
   public user(int id, String name, String email, String pass, String about, boolean enabaled, String imgurl,String role) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.pass = pass;
	this.about = about;
	this.enabaled = enabaled;
	this.imgurl = imgurl;
	this.role=role;
}
@Column(length =100)
//@Size(min = 4,max = 8 ,message="password must be string charaters")
   private String pass;
   @Column(length =100)
   private String about;
   private String role;
   public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
private boolean enabaled;
   private String imgurl;
   @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY ,mappedBy = "user")
   private List<contact> contact=new ArrayList<contact>();
public List<contact> getContact() {
	return contact;
}
public void setContact(List<contact> contact) {
	this.contact = contact;
}
}
