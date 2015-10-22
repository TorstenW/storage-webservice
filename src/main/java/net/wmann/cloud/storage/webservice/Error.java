package net.wmann.cloud.storage.webservice;

public enum Error {
	DATABASE(0, "A database error has occured."), 
	DUPLICATE_USER(1, "This user already exists."),
	INVALID_ARGUMENTS(2, "Invalid request arguments.");

	private final int code;
	private final String description;

	private Error(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public int getCode() {
		return code;
	}

	@Override
	public String toString() {
		return code + ": " + description;
	}
}