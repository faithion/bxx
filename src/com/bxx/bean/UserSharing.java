package com.bxx.bean;

public class UserSharing {
	private int id;
	private int sharingId;
	private int userId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSharingId() {
		return sharingId;
	}
	public void setSharingId(int sharingId) {
		this.sharingId = sharingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "UserSharing [id=" + id + ", sharingId=" + sharingId + ", userId=" + userId + "]";
	}
	
}
