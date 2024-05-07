package br.com.creativesystem.projetointegradorv.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class ErrorAdvice.
 */
@RestControllerAdvice
public class ErrorAdvice {
    
    /**
     * Exception handler.
     *
     * @param exception the exception
     * @param request the request
     * @return the api error
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError ExceptionHandler(NotFoundException exception, HttpServletRequest request) {
        ApiError apiError;
        apiError = new ApiError(HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getServletPath());
        System.out.println(HttpStatus.NOT_FOUND.value());
        return apiError;
        }
}
