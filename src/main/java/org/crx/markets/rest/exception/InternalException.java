package org.crx.markets.rest.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class InternalException extends Exception {

    private static final long serialVersionUID = 1L;

    public InternalException() {
        super();
    }

    public InternalException(final String message) {
        super(message);
    }

    public InternalException(final String message, final Throwable t) {
        super(message, t);
    }

    public InternalException(final Throwable t) {
        this(t.getMessage(), t);
    }

    public static InternalException build() {
        return new InternalException();
    }

    public static InternalException build(final String message) {
        return new InternalException(message);
    }

    public static InternalException build(final String message, final Throwable t) {
        return new InternalException(message, t);
    }

}
