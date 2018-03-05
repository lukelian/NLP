package yun;

import com.google.gson.annotations.SerializedName;

public class Comment_id {
	@SerializedName("numberLong")
	private String num;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
}
