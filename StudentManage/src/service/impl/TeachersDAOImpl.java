package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Teachers;
import service.TeachersDAO;

public class TeachersDAOImpl implements TeachersDAO{

	@Override
	public List<Teachers> queryAllTeachers() {
		// TODO 自动生成的方法存根
		Transaction tx = null;
		String hql = "";
		List<Teachers> list = null;
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "From Teachers";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
			return list;
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return list;
		}
		finally
		{
			if(tx!=null)
				tx = null;
		}
	}

	@Override
	public Teachers queryTeachersBytid(String tid) {
		// TODO 自动生成的方法存根
		Transaction tx = null;
		String hql = "";
		Teachers t = null;
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			t = (Teachers) session.get(Teachers.class, tid);
			tx.commit();
			return t;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return t;
		}
		finally
		{
			if(tx!=null)
				tx = null;
		}
	}

	@Override
	public boolean addTeachers(Teachers t) {
		// TODO 自动生成的方法存根
		t.setTid(getNewTid());
		Transaction tx = null;
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(t);
			tx.commit();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return false;
		}
		finally
		{
			if(tx!=null)
				tx = null;
		}
	}

	@Override
	public boolean deleteTeachers(String tid) {
		// TODO 自动生成的方法存根
		//t.setTid(getNewTid());
		Transaction tx = null;
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Teachers t = (Teachers) session.get(Teachers.class, tid);
			session.delete(t);
			tx.commit();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return false;
		}
		finally
		{
			if(tx!=null)
				tx = null;
		}
	}

	@Override
	public boolean updateTeachers(Teachers t) {
		// TODO 自动生成的方法存根
		//t.setTid(getNewTid());
		Transaction tx = null;
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(t);
			tx.commit();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return false;
		}
		finally
		{
			if(tx!=null)
				tx = null;
		}
	}
	public String getNewTid()
	{
		Transaction tx = null;
		String hql = "";
		String tid = null;
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "selsct max(tid) from teachers";
			Query query = session.createQuery(hql);
			tid = (String) query.uniqueResult();
			if(tid==null||"".equals(tid))
			{
				tid = "t0000001";
			}
			else
			{
				String temp = tid.substring(1);
				int i = Integer.parseInt(temp);
				i++;
				//再还原为字符型
				temp = String.valueOf(i);
				int len = temp.length();
				for(int j=0;j<7-len;j++)
				{
					temp = "0"+temp;
				}
				return tid;
			}
			tx.commit();
			return tid;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return tid;
		}
		finally
		{
			if(tx!=null)
				tx = null;
		}
	}

}
