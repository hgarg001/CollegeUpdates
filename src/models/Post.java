package models;

import java.time.LocalDateTime;

public class Post {

	private Long postId;
	private String postOwnerId;
	private LocalDateTime postDateTime;
	private String postText;
	private byte[] postImage1;
	private byte[] postImage2;
	private byte[] postImage3;
	private byte[] postImage4;
	private Long noOfLikes;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getPostOwnerId() {
		return postOwnerId;
	}

	public void setPostOwnerId(String postOwnerId) {
		this.postOwnerId = postOwnerId;
	}

	public LocalDateTime getPostDateTime() {
		return postDateTime;
	}

	public void setPostDateTime(LocalDateTime postDateTime) {
		this.postDateTime = postDateTime;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public byte[] getPostImage1() {
		return postImage1;
	}

	public void setPostImage1(byte[] postImage1) {
		this.postImage1 = postImage1;
	}

	public byte[] getPostImage2() {
		return postImage2;
	}

	public void setPostImage2(byte[] postImage2) {
		this.postImage2 = postImage2;
	}

	public byte[] getPostImage3() {
		return postImage3;
	}

	public void setPostImage3(byte[] postImage3) {
		this.postImage3 = postImage3;
	}

	public byte[] getPostImage4() {
		return postImage4;
	}

	public void setPostImage4(byte[] postImage4) {
		this.postImage4 = postImage4;
	}

	public Long getNoOfLikes() {
		return noOfLikes;
	}

	public void setNoOfLikes(Long noOfLikes) {
		this.noOfLikes = noOfLikes;
	}

}
