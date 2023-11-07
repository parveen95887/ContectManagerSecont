
 package com.smart.contact.spconfig;
  
  import java.util.Collection; import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.security.core.GrantedAuthority; import
  org.springframework.security.core.authority.SimpleGrantedAuthority; import
  org.springframework.security.core.userdetails.UserDetails;
  
  import com.smart.contact.Entity.user; import
  com.smart.contact.Repository.userRepository;
  
  public class customeUserDetail implements UserDetails{
  
  private user user;
  
  public customeUserDetail(user user) { 
  this.user = user; 
  }
  
  @Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return true;
}

@Override 
public Collection<? extends GrantedAuthority> getAuthorities() {
  SimpleGrantedAuthority sga=new SimpleGrantedAuthority(user.getRole());
  
  return List.of(sga); 
  }
  
 @Override 
 public String getPassword() { 
	 return user.getPass(); 
	 }
   @Override 
   public String getUsername() { 
	   
      return user.getEmail();
   }
  
  }
 