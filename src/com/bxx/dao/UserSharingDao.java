package com.bxx.dao;

import org.apache.ibatis.annotations.Param;

import com.bxx.bean.UserSharing;

public interface UserSharingDao {
	UserSharing selectById(int id);
	int insert(@Param("us")UserSharing us);
	int delete(int sharingId);
}
