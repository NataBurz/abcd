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
		
		//метод який зберігає об`єкт в БД
		//ссилка на об`єкт є параметром методу
		//важливо зберігати послідовність зберігання об`єктів
		//не можна зберігати об`єкт полем якого є інший об`єкт
		//який ще не збережений до БД
		public void save(User user){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.save(user);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//метод який оновлює усі поля об`єкту, крім id
		//без id генерує помилку
		public void update(User user){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.update(user);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//метод який видаляє об`єкт з БД
		//без id нічого не робить
		public void delete(User user){
			Session ses = sessionFactory.openSession();
			ses.beginTransaction();
			ses.delete(user);
			ses.getTransaction().commit();
			ses.close();
		}
		
		//метод який повертає усі об`єкти з БД
		//unchecked тому що java не може точно перевірити що повернеться з БД
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
