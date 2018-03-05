package yun;

import java.util.List;

import javax.xml.crypto.Data;

import com.google.gson.annotations.SerializedName;

public class Comment {
	@SerializedName("p_id")
	private String pId;
//	@SerializedName("comment_id")
//	private List<Comment_id> commentId;
	@SerializedName("content")
	private String content;
	@SerializedName("creation_time")
	private String createTime;
	@SerializedName("score")
	private double score;
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
//	public List<Comment_id> getCommentId() {
//		return commentId;
//	}
//	public void setCommentId(List<Comment_id> commentId) {
//		this.commentId = commentId;
//	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
}
