package org.sixdouglas.formation.spring.irrigation;

public class BrokenDropperException extends Exception {
    public BrokenDropperException() { super(); }
    public BrokenDropperException(String message) { super(message); }
    public BrokenDropperException(Throwable cause) { super(cause); }
    public BrokenDropperException(String message, Throwable cause) { super(message, cause); }
}
