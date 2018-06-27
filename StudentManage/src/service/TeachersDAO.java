package service;

import java.util.List;

import entity.Teachers;

//老师的业务逻辑接口
public interface TeachersDAO {

	//查询所有老师的信息
	public List<Teachers> queryAllTeachers();
	//根据工号查询老师的信息
	public Teachers queryTeachersBytid(String tid);
	//添加教师信息
	public boolean addTeachers(Teachers t);
	//删除教师信息
	public boolean deleteTeachers(String tid);
	//更新教师信息
	public boolean updateTeachers(Teachers t);
}
