package sda.springbasic.jpaworkshop.exceptions;

public class NoSuchEmployeeInBaseException extends RuntimeException{
    public NoSuchEmployeeInBaseException() {
        super("No such employee in base.");
    }
}
