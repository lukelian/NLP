package yun;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Comments {
	@SerializedName("p_id")
	private String id;
	@SerializedName("comments")
	private List<Comment> comments;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
