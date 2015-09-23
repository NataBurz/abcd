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
		
		//метод який зберігає об`єкт в БД
		//ссилка на об`єкт є параметром методу
		//важливо зберігати послідовність зберігання об`єктів
		//не можна зберігати об`єкт полем якого є інший об`єкт
		//який ще не збережений до БД
		public void save(CreateTopic createTopic){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.save(createTopic);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//метод який оновлює усі поля об`єкту, крім id
		//без id генерує помилку
		public void update(CreateTopic createTopic){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.update(createTopic);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//метод який видаляє об`єкт з БД
		//без id нічого не робить
		public void delete(CreateTopic createTopic){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.delete(createTopic);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//метод який повертає усі об`єкти з БД
		//unchecked тому що java не може точно перевірити що повернеться з БД
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

