package daoImpl;

import java.util.List;

import domain.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class UserDaoImpl {

		SessionFactory sessionFactory;

		public void userDaoImpl() {
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
					configuration.getProperties()).build();
			sessionFactory = new Configuration().configure().buildSessionFactory(
					serviceRegistry);
		}
		
		public void closeSessionFactory(){
			sessionFactory.close();
		}
		
		//����� ���� ������ ��`��� � ��
		//������ �� ��`��� � ���������� ������
		//������� �������� ����������� ��������� ��`����
		//�� ����� �������� ��`��� ����� ����� � ����� ��`���
		//���� �� �� ���������� �� ��
		public void save(User user){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.save(user);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//����� ���� ������� �� ���� ��`����, ��� id
		//��� id ������ �������
		public void update(User user){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.update(user);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//����� ���� ������� ��`��� � ��
		//��� id ����� �� ������
		public void delete(User user){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.delete(user);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//����� ���� ������� �� ��`���� � ��
		//unchecked ���� �� java �� ���� ����� ��������� �� ����������� � ��
		@SuppressWarnings("unchecked")
		public List<User> getAll(){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			List<User> users;
			users = ses.createCriteria(User.class).list();
			ses.getTransaction().commit();
			ses.close();
			return users;
		}



}
