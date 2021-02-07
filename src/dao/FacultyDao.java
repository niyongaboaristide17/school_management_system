/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Faculty;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author aristide
 */
public class FacultyDao {
    
    private static Session session;
    
    public static Faculty create(Faculty faculty){
        
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(faculty);
        session.getTransaction().commit();
        session.close();
        return faculty;
        
    }
    
}
