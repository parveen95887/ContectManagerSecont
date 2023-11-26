package com.smart.contact.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class contact{

	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
    @NotNull(message="name field is required")
	@Size(max=50,min = 5,message="name must be 5 to 50 charaters")
	//@Pattern(regexp = "^[A-Za-z]", message = "name is must be charater")
	private String name;
    @NotNull(message="nicname field is required")
	@Size(max=20,min = 4,message="name must be 5 to 10 charaters")
	private String nicname;
	@Override
	public String toString() {
		return "contact [cid=" + cid + ", name=" + name + ", nicname=" + nicname + ", about=" + about + ", phone="
				+ phone + ", email=" + email + ", work=" + work + ", img=" + image + ", user=" + user + "]";
	}
	public contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public contact(int cid, String name, String nicname, String about, String phone, String email, String work, String img,
			com.smart.contact.Entity.user user){
		super();
		this.cid = cid;
		this.name = name;
		this.nicname = nicname;
		this.about = about;
		this.phone = phone;
		this.email = email;
		this.work = work;
		this.image = img;
		this.user = user;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNicname() {
		return nicname;
	}
	public void setNicname(String nicname) {
		this.nicname = nicname;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getImg() {
		return image;
	}
	public void setImg(String img) {
		this.image = img;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	
	@Column(length = 500)
	private String about;
   //@Max(11)
  //@NotNull(message="phonenumber field is required")
 //@NotEmpty(message="phonenumber field is required")
	@Pattern(regexp = "\\d{10}", message ="Phone number must be 10 digits")
	private String phone;
	@Email
    @NotNull(message="Email field is required")
	private String email;
	@Size(max = 100,min = 10,message = "Enter work between 20 to 100 charaters")
	private String work;
	@NotNull(message="img field needed")
	private String image;
	@ManyToOne
	private user user;
}
