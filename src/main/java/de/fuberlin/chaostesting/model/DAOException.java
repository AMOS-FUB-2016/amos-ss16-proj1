package de.fuberlin.chaostesting.model;

@SuppressWarnings("serial")
public class DAOException extends RuntimeException {

	public DAOException() {
		super();
	}

	public DAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}
	
}
