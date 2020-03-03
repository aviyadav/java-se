package com.sample.db.postgres.jsonb.error;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@ControllerAdvice
@Slf4j
public class ExceptionProcessor {

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorInfo handleDataNotFoundException(HttpServletRequest req, DataNotFoundException ex) {
        ErrorInfo info = getErrorInfo(req, HttpStatus.NOT_FOUND);
        info.setMessage(ex.getMessage());

        return info;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorInfo handleIllegalArgException(HttpServletRequest req, IllegalArgumentException ex) {
        ErrorInfo info = getErrorInfo(req, HttpStatus.BAD_REQUEST);
        info.setMessage(ex.getMessage());

        return info;
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorInfo handleIllegalStateException(HttpServletRequest req, IllegalStateException ex) {
        ErrorInfo info = getErrorInfo(req, HttpStatus.BAD_REQUEST);
        info.setMessage(ex.getMessage());

        return info;
    }

    private ErrorInfo getErrorInfo(HttpServletRequest req, HttpStatus httpStatus) {
        ErrorInfo info = new ErrorInfo();
        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromServletMapping(req);
        info.setPath(builder.path(req.getRequestURI()).build().getPath());
        info.setCode(httpStatus.value());
        info.setType(httpStatus.getReasonPhrase());
        return info;
    }
}
