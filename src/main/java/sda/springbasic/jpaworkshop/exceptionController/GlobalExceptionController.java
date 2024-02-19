package sda.springbasic.jpaworkshop.exceptionController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sda.springbasic.jpaworkshop.exceptions.NoDepartmentInBaseException;
import sda.springbasic.jpaworkshop.exceptions.NoDepartmentsInCityException;
import sda.springbasic.jpaworkshop.exceptions.NoSuchEmployeeInBaseException;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(NoDepartmentInBaseException.class)
    public ResponseEntity<String> noDepInBase(NoDepartmentInBaseException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(NoDepartmentsInCityException.class)
    public ResponseEntity<String> noRepInCity(NoDepartmentsInCityException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler({NoSuchEmployeeInBaseException.class})
    public ResponseEntity<String> noEmpInBase(NoSuchEmployeeInBaseException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
