package com.smart.contact.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.contact.Entity.user;

public interface userRepository extends JpaRepository<user,Integer>{
 
	@Query("select u from user u where u.email =:email ")
	public user getUserByUserName(@Param("email") String email);
}
