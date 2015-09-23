package daoImpl;

import java.util.List;

import domain.CreateTopic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class CreateTopicDaoImpl {

		SessionFactory sessionFactory;

		public void createTopicDaoImpl() {
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
		public void save(CreateTopic createTopic){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.save(createTopic);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//����� ���� ������� �� ���� ��`����, ��� id
		//��� id ������ �������
		public void update(CreateTopic createTopic){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.update(createTopic);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//����� ���� ������� ��`��� � ��
		//��� id ����� �� ������
		public void delete(CreateTopic createTopic){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.delete(createTopic);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//����� ���� ������� �� ��`���� � ��
		//unchecked ���� �� java �� ���� ����� ��������� �� ����������� � ��
		@SuppressWarnings("unchecked")
		public List<CreateTopic> getAll(){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			List<CreateTopic> createTopics;
			createTopics = ses.createCriteria(CreateTopic.class).list();
			ses.getTransaction().commit();
			ses.close();
			return createTopics;
		}



}

