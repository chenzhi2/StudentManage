package action;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
import service.UsersDAO;
import service.impl.UsersDAOImpl;

public class UsersAction extends SuperAction implements ModelDriven<Users>{

	private Users user = new Users();

	//用户登录动作
	public String login()
	{
		UsersDAO udao = new UsersDAOImpl();
		if(udao.usersLogin(user))
		{
			//在session中保存登录成功的用户名
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		}
		else
		{
			return "login_failure";
		}
	}
	//注销的方法
	public String logout()
	{
		if(session.getAttribute("loginUserName")!=null)
		{
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	
	@Override
	public Users getModel() {
		// TODO 自动生成的方法存根
		return this.user;
	}
	

}
