package net.danixy8.encuesta.backend.services;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.danixy8.encuesta.backend.entities.UserEntity;
import net.danixy8.encuesta.backend.models.requests.UserRegisterRequestModel;
import net.danixy8.encuesta.backend.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

  UserRepository userRepository;

  BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  public UserEntity createUser(UserRegisterRequestModel user){
    UserEntity userEntity = new UserEntity();

    BeanUtils.copyProperties(user, userEntity);

    userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));

    return userRepository.save(userEntity);
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    UserEntity userEntity = userRepository.findByEmail(email);

    if (userEntity == null){
      throw new UsernameNotFoundException(email);
    }

    return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
  }

  @Override
  public UserEntity getUser(String email) {
    return userRepository.findByEmail(email);
  }

  
}
