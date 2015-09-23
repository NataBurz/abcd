package daoImpl;

import java.util.List;

import domain.Sex;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SexDaoImpl {

		SessionFactory sessionFactory;

		public void sexDaoImpl() {
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
		public void save(Sex sex){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.save(sex);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//����� ���� ������� �� ���� ��`����, ��� id
		//��� id ������ �������
		public void update(Sex sex){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.update(sex);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//����� ���� ������� ��`��� � ��
		//��� id ����� �� ������
		public void delete(Sex sex){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.delete(sex);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//����� ���� ������� �� ��`���� � ��
		//unchecked ���� �� java �� ���� ����� ��������� �� ����������� � ��
		@SuppressWarnings("unchecked")
		public List<Sex> getAll(){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			List<Sex> sexs;
			sexs = ses.createCriteria(Sex.class).list();
			ses.getTransaction().commit();
			ses.close();
			return sexs;
		}



}



