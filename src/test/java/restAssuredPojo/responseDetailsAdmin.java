package restAssuredPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class responseDetailsAdmin {
	
	@JsonProperty
	String success;
	@JsonProperty
	String[] error;
	@JsonProperty
	AdminDetailsPojo data;
	
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
	public AdminDetailsPojo getData() {
		return data;
	}
	public void setData(AdminDetailsPojo data) {
		this.data = data;
	}
	
	
	

}
