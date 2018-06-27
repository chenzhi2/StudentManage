package action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

//所有action的父类
public class SuperAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ServletContext application;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected HttpServletRequest request;
	@Override
	public void setServletContext(ServletContext application) {
		// TODO 自动生成的方法存根
		this.application = application;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO 自动生成的方法存根
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO 自动生成的方法存根
		this.request = request;
		this.session = this.request.getSession();
	}

}
