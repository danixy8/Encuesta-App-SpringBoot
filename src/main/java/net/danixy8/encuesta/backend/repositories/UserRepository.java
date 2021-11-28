package net.danixy8.encuesta.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.danixy8.encuesta.backend.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository <UserEntity, Long>{
  public UserEntity findByEmail(String email);
  
}
