package com.api.consultorio.exceptions;

import com.api.consultorio.model.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Controla los errores NOT FOUND
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex,
                                                                       WebRequest webRequest) {
        ApiResponse apiResponse = new ApiResponse(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);

    }

    // Controla el error del conflicto al crear turno
    @ExceptionHandler(TurnoConflictException.class)
    public ResponseEntity<ApiResponse> handleTurnoConflict(TurnoConflictException ex, WebRequest webRequest) {
        ApiResponse apiResponse = new ApiResponse(ex.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
    }

    // Controla error de ruta inexistente
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiResponse> handlerNoHandlerFoundException(NoHandlerFoundException exception,
                                                                      WebRequest webRequest) {
        ApiResponse apiResponse = new ApiResponse(exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    // Controla algun error de logica
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse> handlerBadRequestException(BadRequestException exception,
                                                                  WebRequest webRequest) {
        ApiResponse apiResponse = new ApiResponse(exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }


    // Controla errores de varios tipos
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handlerException(Exception ex,
                                                        WebRequest webRequest) {
        ApiResponse apiResponse = new ApiResponse(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
