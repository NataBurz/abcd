package daoImpl;


import java.util.List;

import domain.Comment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class CommentDaoImpl {

		SessionFactory sessionFactory;

		public void commentDaoImpl() {
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
		public void save(Comment comment){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.save(comment);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//����� ���� ������� �� ���� ��`����, ��� id
		//��� id ������ �������
		public void update(Comment comment){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.update(comment);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//����� ���� ������� ��`��� � ��
		//��� id ����� �� ������
		public void delete(Comment comment){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.delete(comment);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//����� ���� ������� �� ��`���� � ��
		//unchecked ���� �� java �� ���� ����� ��������� �� ����������� � ��
		@SuppressWarnings("unchecked")
		public List<Comment> getAll(){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			List<Comment> comments;
			comments = ses.createCriteria(Comment.class).list();
			ses.getTransaction().commit();
			ses.close();
			return comments;
		}



}




