package com.smart.contact.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class contact {

	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String name;
	private String nicname;
	@Override
	public String toString() {
		return "contact [cid=" + cid + ", name=" + name + ", nicname=" + nicname + ", about=" + about + ", phone="
				+ phone + ", email=" + email + ", work=" + work + ", img=" + img + ", user=" + user + "]";
	}
	public contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public contact(int cid, String name, String nicname, String about, int phone, String email, String work, String img,
			com.smart.contact.Entity.user user){
		super();
		this.cid = cid;
		this.name = name;
		this.nicname = nicname;
		this.about = about;
		this.phone = phone;
		this.email = email;
		this.work = work;
		this.img = img;
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
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
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
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	
	@Column(length = 500)
	private String about;
	private int phone;
	private String email;
	private String work;
	private String img;
	@ManyToOne
	private user user;
	
}
