package org.crx.markets.rest.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class InternalException extends Exception {

    private static final long serialVersionUID = 1L;

    public InternalException() {
        super();
    }

    public InternalException(final String message) {
        super(abbreviateToOneLine(message));
    }

    public InternalException(final String message, final Throwable t) {
        super(abbreviateToOneLine(message), t);
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

    public static InternalException build(final Throwable t) {
        if (t instanceof InternalException) {
            return (InternalException) t;
        }
        return new InternalException(t);
    }

    public static RuntimeException buildAsRuntime(final String message) {
        return new RuntimeException(build(message));
    }

    public static RuntimeException buildAsRuntime(final String message, final Throwable t) {
        return new RuntimeException(build(message, t));
    }

    public static RuntimeException buildAsRuntime(final Throwable t) {
        return new RuntimeException(build(t));
    }

    private static String abbreviateToOneLine(final String str) {
        String result = "";
        if (str != null) {
            result = str.replaceAll("\\r\\n", " ").replaceAll("\\n", " ");
        }
        return result;
    }

}
