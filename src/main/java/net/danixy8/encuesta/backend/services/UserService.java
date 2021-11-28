package net.danixy8.encuesta.backend.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import net.danixy8.encuesta.backend.entities.UserEntity;
import net.danixy8.encuesta.backend.models.requests.UserRegisterRequestModel;

public interface UserService extends UserDetailsService{

  public UserDetails loadUserByUsername(String email);

  public UserEntity getUser(String email);

  public UserEntity createUser(UserRegisterRequestModel user);
  
}
