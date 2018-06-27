package action;

import java.util.List;

import entity.Teachers;
import service.TeachersDAO;
import service.impl.TeachersDAOImpl;

public class TeachersAction extends SuperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//查询所有老师的动作
	public String query()
	{
		TeachersDAO tdao = new TeachersDAOImpl();
		List<Teachers> list = tdao.queryAllTeachers();
		if(list!=null||list.size()>0)
		{
			session.setAttribute("teachers_list", list);
		}
		return "query_success";
	}
}
