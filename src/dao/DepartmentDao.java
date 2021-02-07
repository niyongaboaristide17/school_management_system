/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Department;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author aristide
 */
public class DepartmentDao {
    
    private static Session session;
    
    public static Department create(Department department){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(department);
        session.getTransaction().commit();
        session.close();
        return department;
    }
    
}
