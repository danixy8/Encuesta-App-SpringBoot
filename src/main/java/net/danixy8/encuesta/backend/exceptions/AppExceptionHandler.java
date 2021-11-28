package net.danixy8.encuesta.backend.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import net.danixy8.encuesta.backend.models.responses.ValidationsErrors;

@ControllerAdvice
public class AppExceptionHandler {
  
  @ExceptionHandler(value = { MethodArgumentNotValidException.class })
  public ResponseEntity<Object> handleValidationErrorException(MethodArgumentNotValidException ex, WebRequest web){

    Map<String, String> errors = new HashMap<>();

    for (ObjectError error : ex.getBindingResult().getAllErrors()) {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    }
    
    ValidationsErrors validationErros = new ValidationsErrors(errors, new Date());

    return new ResponseEntity<>(validationErros, new HttpHeaders(), HttpStatus.BAD_REQUEST);

  }

}
