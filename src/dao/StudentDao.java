/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Student;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author aristide
 */
public class StudentDao {
    
    private static Session session;
    
    public static Student create(Student student){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        return student;
    }
    
    public static Student update(Student student){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
        session.close();
        return student;
    }
    
    public static Student delete(Student student){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
        session.close();
        return student;
    }
    
    public static List<Student> findAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Student> students = session.createQuery("From Student").list();
        session.close();
        return students;
    }
    
    public static Student findOne(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }
    
}
