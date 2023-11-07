  package com.smart.contact.spconfig;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.smart.contact.Entity.user;
import com.smart.contact.Repository.userRepository;
import com.smart.contact.Repository.userRepository;
  
  public class userServiceImpl implements UserDetailsService{
  
  @Autowired 
  private userRepository userRepo;
  
  @Override 
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
  { 
	  user userByUserName =userRepo.getUserByUserName(username); 
	  if(userByUserName==null)
	  {
     throw new UsernameNotFoundException("could not found user"); 
    }
  customeUserDetail cud=new customeUserDetail(userByUserName);
  return cud; 
  } 
  }
 