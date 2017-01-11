package co.com.netcom.mpos.dto;

public class UserLoginDTO {

	public UserLoginDTO(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}

	private String message;
	private String code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
