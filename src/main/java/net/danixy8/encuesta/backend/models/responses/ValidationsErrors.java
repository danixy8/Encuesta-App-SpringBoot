package net.danixy8.encuesta.backend.models.responses;

import java.util.Date;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationsErrors {
  private Map<String, String> errors;
  private Date timestamp;
  
}
