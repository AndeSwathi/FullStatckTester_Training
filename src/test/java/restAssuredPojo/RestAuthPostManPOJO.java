package restAssuredPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestAuthPostManPOJO {
	@JsonProperty
	String success;
	@JsonProperty
	String[] error;
	@JsonProperty
	
	RestAuthDataPOJO data;
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String[] getError() {
		return error;
	}
	public void setError(String[] error) {
		this.error = error;
	}
	public RestAuthDataPOJO getData() {
		return data;
	}
	public void setData(RestAuthDataPOJO data) {
		this.data = data;
	}
	

}
