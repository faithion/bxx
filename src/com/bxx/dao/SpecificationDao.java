package com.bxx.dao;
import org.apache.ibatis.annotations.Param;
import com.bxx.bean.Specification;

public interface SpecificationDao {
//	List<User> selectAll();
	Specification selectById(int id);
	Specification selectByNo(String no);
	int insert(@Param("spe")Specification spe);
	int delete(int id);
	int update(@Param("spe")Specification spe);
}
