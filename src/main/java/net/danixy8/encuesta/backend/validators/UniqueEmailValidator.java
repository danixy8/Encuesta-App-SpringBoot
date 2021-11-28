package net.danixy8.encuesta.backend.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import net.danixy8.encuesta.backend.annotations.UniqueEmail;
import net.danixy8.encuesta.backend.entities.UserEntity;
import net.danixy8.encuesta.backend.repositories.UserRepository;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>{

  @Autowired
  UserRepository userRepository;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    UserEntity user = userRepository.findByEmail(value);
    if(user == null){
      return true;
    }
    return false;
  }
  
}
