package com.example.common.notify;

public class ConfigEMail {
	private boolean enable;
	private String username;
	private String password;
	
	public ConfigEMail() {
		super();
	}
	public ConfigEMail(boolean enable, String username, String password) {
		super();
		this.enable = enable;
		this.username = username;
		this.password = password;
	}
	
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
