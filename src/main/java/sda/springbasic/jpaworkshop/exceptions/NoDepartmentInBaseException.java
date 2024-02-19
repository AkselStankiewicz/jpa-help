package sda.springbasic.jpaworkshop.exceptions;

public class NoDepartmentInBaseException extends RuntimeException{
    public NoDepartmentInBaseException() {
        super("No such department in base.");
    }
}
