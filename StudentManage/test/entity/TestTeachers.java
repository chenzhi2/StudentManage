package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

//
public class TestTeachers {

	@Test
	public void testSchemaExport()
	{
		//创建配置对象
		Configuration config = new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建会话对象
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		//创建session对象
		Session session = sessionFactory.getCurrentSession();
		//创建SchemaExport对象
		SchemaExport export = new SchemaExport(config);
		export.create(true, true);//
	}
	@Test
	public void testSaveTeachers()
	{
		//创建配置对象
		Configuration config = new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建会话对象
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		//创建session对象
		Session session = sessionFactory.getCurrentSession();
		//创建事务对象
		Transaction tx = session.beginTransaction();//开启事务
		Teachers t1 = new Teachers("t0000001","李政委","男",42,"数据库");
		Teachers t2 = new Teachers("t0000002","徐慧","女",32,"应用软件开发");
		session.save(t1);
		session.save(t2);
		tx.commit();
		sessionFactory.close();
		
	}
}
