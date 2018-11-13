package com.kn.dto;

/**
 * @author krishnanand
 *
 */
public class Message {
	public enum TYPE {
		ERROR, MESSAGE
	}

	private int status = 200;
	private String type;
	private String message;

	/**
	 * @param status
	 * @param type
	 * @param message
	 */
	public Message(int status, Enum<TYPE> type, String message) {
		super();
		this.status = status;
		this.type = type.name();
		this.message = message;
	}

	public Message() {
		super();
	}

	/**
	 * @param type
	 * @param message
	 */
	public Message(Enum<TYPE> type, String message) {
		super();
		this.type = type.name();
		this.message = message;
	}

	/**
	 * sets type as MESSAGE, status as 200 and message as given message
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		type = TYPE.MESSAGE.name();
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Enum<Message.TYPE> type) {
		this.type = type.name();
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}
