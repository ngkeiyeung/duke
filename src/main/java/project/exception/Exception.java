package project.exception;

public class Exception extends java.lang.Exception {
    /**
     * Show the Exception error with different function
     *
     * @param warning Shows the error message
     */

    public Exception(String warning) {
        super(warning);
    }
}
