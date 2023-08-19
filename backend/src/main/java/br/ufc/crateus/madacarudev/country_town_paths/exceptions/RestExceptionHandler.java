package br.ufc.crateus.madacarudev.country_town_paths.exceptions;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.InformativeMessageOutputDto;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{     
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<InformativeMessageOutputDto> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException,
    HttpServletRequest request) {
        InformativeMessageOutputDto informativeMessage = new InformativeMessageOutputDto();
        informativeMessage.setMessage(entityNotFoundException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(informativeMessage);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(EntityConflictException.class)
    public ResponseEntity<InformativeMessageOutputDto> handleEntityConflictException(EntityConflictException entityConflictException,
    HttpServletRequest request) {
        InformativeMessageOutputDto informativeMessage = new InformativeMessageOutputDto();
        informativeMessage.setMessage(entityConflictException.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(informativeMessage);
    }

//...

}
