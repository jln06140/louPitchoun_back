package co.simplon.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Jwt")
public class JwtDto {

	private String token;

	@ApiModelProperty("The jwt token")
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "JwtDto{" +
				"token='" + token + '\'' +
				'}';
	}
}
