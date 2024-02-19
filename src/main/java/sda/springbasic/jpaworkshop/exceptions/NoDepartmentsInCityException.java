package sda.springbasic.jpaworkshop.exceptions;

public class NoDepartmentsInCityException extends RuntimeException{
    public NoDepartmentsInCityException() {
        super("No departments in provided city.");
    }
}
