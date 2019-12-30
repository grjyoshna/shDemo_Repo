package com.sh.Dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sh.HibernateUtil;
import com.sh.Entity.Student;

@Repository
public class studentDaoImpl implements studentDao{

	SessionFactory Factory=new Configuration().
			configure("hibernate.cfg.xml").
			addAnnotatedClass(Student.class).
			buildSessionFactory();
	
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		
		
		
		try(Session session=HibernateUtil.getSession()) {
			System.out.println("Creating new student object..");
			//Student newStud=new Student("Jyoshna", "Gurrala", "jyoshna@gmail.com");
			
			session.beginTransaction();
			
			Query q= session.createQuery("from Student",Student.class);
			List<Student> students=q.getResultList();
		
			session.getTransaction().commit();
			System.out.println("Done!");
			
			return students;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		
		try(Session session=HibernateUtil.getSession())
		{
			//System.out.println("Session created"+id);
			session.beginTransaction();
			Query q=session.createQuery("delete from Student where id=:newId");
			q.setParameter("newId", id);
			q.executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}catch(Exception e)
		{
			System.out.println("ID not found");
			e.printStackTrace();
			
		}
		
	}

	public void createStudent(Student stud) {
		// TODO Auto-generated method stub
		
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.saveOrUpdate(stud);
		//	Integer count =session.createQuery("select count(1) from Student", Student.class).getSingleResult();
			session.getTransaction().commit();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void updateStudent(int id) {
		// TODO Auto-generated method stub
		
	}

	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSession()) {
			//System.out.println("Creating new student object..");
			//Student newStud=new Student("Jyoshna", "Gurrala", "jyoshna@gmail.com");
			
			session.beginTransaction();
			
			Student stud=session.get(Student.class,id);
		System.out.println(stud);
			session.getTransaction().commit();
			System.out.println("Done!");
			
			return stud;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void updateStudent(Student stud) {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.saveOrUpdate(stud);
			session.getTransaction().commit();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void createStudents(List<Student> students) {
		// TODO Auto-generated method stub
		
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.saveOrUpdate(students);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	}
