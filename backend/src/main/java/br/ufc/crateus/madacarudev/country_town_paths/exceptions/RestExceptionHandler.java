package br.ufc.crateus.madacarudev.country_town_paths.exceptions;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.InformativeMessageOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.ValidationErrorMessageOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.ValidationFieldErrorOutputDto;
import lombok.RequiredArgsConstructor;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler extends ResponseEntityExceptionHandler{    
    private final MessageSource messageSource;
    
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<InformativeMessageOutputDto> handleBadRequestException(BadRequestException badRequestException,
    HttpServletRequest request) {
        InformativeMessageOutputDto informativeMessage = new InformativeMessageOutputDto();
        informativeMessage.setMessage(badRequestException.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(informativeMessage);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<ValidationFieldErrorOutputDto> fieldErrorList = this.mapBindExceptionToFieldError(exception);
        
        var validationErrorMessage = new ValidationErrorMessageOutputDto();
        validationErrorMessage.setMessage("Um ou mais campos inválidos");
        validationErrorMessage.setErrors(fieldErrorList);

        return this.handleExceptionInternal(exception, validationErrorMessage, headers, HttpStatus.BAD_REQUEST, request);
    }

    private List<ValidationFieldErrorOutputDto> mapBindExceptionToFieldError(BindException exception) {
        List<ValidationFieldErrorOutputDto> fieldErrorsList = new ArrayList<ValidationFieldErrorOutputDto>();
    
        for (ObjectError error : exception.getBindingResult().getAllErrors()) {
          var fieldName = ((FieldError) error).getField();
          var errorDescription = this.messageSource.getMessage(error, LocaleContextHolder.getLocale());
    
          var validationFieldError = new ValidationFieldErrorOutputDto();
    
          validationFieldError.setFieldName(fieldName);
          validationFieldError.setErrorDescription(errorDescription);
    
          fieldErrorsList.add(validationFieldError);
        }
    
        return fieldErrorsList;
    }
}
