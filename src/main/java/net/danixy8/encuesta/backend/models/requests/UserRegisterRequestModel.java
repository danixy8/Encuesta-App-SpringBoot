package net.danixy8.encuesta.backend.models.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import net.danixy8.encuesta.backend.annotations.UniqueEmail;

@Data
public class UserRegisterRequestModel {

  @NotEmpty
  private String name;

  @NotEmpty
  @Email
  @UniqueEmail
  private String email;

  @NotEmpty
  @Size(min = 8, max = 40)
  private String password;
  
}
