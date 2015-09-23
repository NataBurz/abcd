package controller;

import daoImpl.TopicDaoImpl;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;

	public class Main {

		public static void main(String[] args) {
			EntityManagerFactory factory = Persistence
					.createEntityManagerFactory("primary");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			//� resources � �� �����, ��� ������ ���� ���������, ����������� persistence.xml
			//��� ��������� ��������
			//��������������� ������ persist, merge, find, remove
			em.getTransaction().commit();
			em.close();
			factory.close();
		}

	}


//	public static void main(String[] args) {
//		TopicDaoImpl t = new TopicDaoImpl();
//		t.closeSessionFactory();
//	}

