package com.mouritech.hibernateexample;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.hibernate.entity.Course;
import com.mouritech.hibernate.entity.Student;
import com.mouritech.hibernate.util.Hibernate;

public class HibernateExampleMain {

	public static void main(String[] args) {

		Student student = new Student(1235L, "navya", "lakki", "898983534");
		Student student1 = new Student(1245L, "chinnu", "chandra", "9861100345");
		
		Course c = new Course("Java", "45000");
		Course c1 = new Course("Angular", "35000");
		Course c2 = new Course("Python with DataScience","55000");
		
		Transaction transaction = null;

		try (Session session = Hibernate.getSessionFactory().openSession()) {

			// start the transaction
			transaction = session.beginTransaction();
			// save the student objects in to database
			session.save(student);
			session.save(student1);
			// commit transaction
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}

		// retrieve the data from database to java program using hibernate

		try (Session session = Hibernate.getSessionFactory().openSession()) {

			List<Student> studentList = session.createQuery("from Student", Student.class).list();
			studentList.forEach(stud -> System.out.println(stud));

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		
		
		//add course data to the db using hibernate
		try (Session session = Hibernate.getSessionFactory().openSession()) {

			// start the transaction
			transaction = session.beginTransaction();
			// save the student objects in to database
			session.save(c);
			session.save(c1);
			session.save(c2);
			// commit transaction
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
		
		// retrieve the data from database to java program using hibernate

		try (Session session = Hibernate.getSessionFactory().openSession()) {

			List<Course> courseList = session.createQuery("from Course", Course.class).list();
			courseList.forEach(cr -> System.out.println(cr));

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

}