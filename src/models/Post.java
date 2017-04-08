package models;

import java.time.LocalDateTime;

public class Post {

	private Long post_id;
	private String post_owner_id;
	private LocalDateTime post_date_time;
	private String post_text;
	private Byte[] post_image1;
	private Byte[] post_image2;
	private Byte[] post_image3;
	private Byte[] post_image4;
	

	public Byte[] getPost_image1() {
		return post_image1;
	}

	public void setPost_image1(Byte[] post_image1) {
		this.post_image1 = post_image1;
	}

	public Byte[] getPost_image2() {
		return post_image2;
	}

	public void setPost_image2(Byte[] post_image2) {
		this.post_image2 = post_image2;
	}

	public Byte[] getPost_image3() {
		return post_image3;
	}

	public void setPost_image3(Byte[] post_image3) {
		this.post_image3 = post_image3;
	}

	public Byte[] getPost_image4() {
		return post_image4;
	}

	public void setPost_image4(Byte[] post_image4) {
		this.post_image4 = post_image4;
	}

	private Integer no_of_likes;

	public Long getPost_id() {
		return post_id;
	}

	public void setPost_id(Long post_id) {
		this.post_id = post_id;
	}

	public String getPost_owner_id() {
		return post_owner_id;
	}

	public void setPost_owner_id(String post_owner_id) {
		this.post_owner_id = post_owner_id;
	}

	public LocalDateTime getPost_date_time() {
		return post_date_time;
	}

	public void setPost_date_time(LocalDateTime post_date_time) {
		this.post_date_time = post_date_time;
	}

	public String getPost_text() {
		return post_text;
	}

	public void setPost_text(String post_text) {
		this.post_text = post_text;
	}

	public Integer getNo_of_likes() {
		return no_of_likes;
	}

	public void setNo_of_likes(Integer no_of_likes) {
		this.no_of_likes = no_of_likes;
	}

}
