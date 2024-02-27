package br.com.jaa.api.features.shared.controllers;


import br.com.jaa.api.features.shared.dtos.ExceptionResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;

@ControllerAdvice
public class ExceptionHandlerController {

    private MessageSource messageSource;

    public ExceptionHandlerController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDto> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e
    ) throws JsonProcessingException {
        var status = HttpStatus.BAD_REQUEST;

        var message = "validation-failed";

//        var stringWriter = new StringWriter();
//        var printWriter = new PrintWriter(stringWriter);
//        e.printStackTrace(printWriter);

        var data = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            var fieldName = ((FieldError) error).getField();
            var errorMessage = error.getDefaultMessage();
            data.put(fieldName, errorMessage);
        });

        var timestamp = Timestamp.valueOf(LocalDateTime.now());

        var response = ExceptionResponseDto.builder()
                .status(status.value())
                .message(message)
//                .stackTrace(stringWriter.toString())
                .data(data)
                .timestamp(timestamp)
                .build();

        return ResponseEntity
                .status(status)
                .body(response);
    }

}
