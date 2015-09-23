package daoImpl;

import java.util.List;

import domain.Topic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class TopicDaoImpl {

		SessionFactory sessionFactory;

		public void topicDaoImpl() {
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
		public void save(Topic topic){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.save(topic);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//����� ���� ������� �� ���� ��`����, ��� id
		//��� id ������ �������
		public void update(Topic topic){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.update(topic);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//����� ���� ������� ��`��� � ��
		//��� id ����� �� ������
		public void delete(Topic topic){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.delete(topic);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//����� ���� ������� �� ��`���� � ��
		//unchecked ���� �� java �� ���� ����� ��������� �� ����������� � ��
		@SuppressWarnings("unchecked")
		public List<Topic> getAll(){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			List<Topic> topics;
			topics = ses.createCriteria(Topic.class).list();
			ses.getTransaction().commit();
			ses.close();
			return topics;
		}



}

