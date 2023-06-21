package src.Exceptions;

import java.security.spec.ECFieldF2m;

public class InvalidProductAttributeException extends Exception {

    public InvalidProductAttributeException(String message) {
        super(message);
    }
}
