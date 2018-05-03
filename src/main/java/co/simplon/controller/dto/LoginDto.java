package co.simplon.controller.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Login")
public class LoginDto {

	@NotNull
	@Pattern(regexp = "^[a-z]+$")
	private String username;
	
	@NotNull
	private String password;
	
	@ApiModelProperty("The username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@ApiModelProperty("The password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
