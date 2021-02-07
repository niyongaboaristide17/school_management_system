/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Department;
import domain.Gender;
import domain.Student;
import java.time.LocalDate;
import java.time.Month;
import operation.AbstractTestClass;
import operation.CommonOperation;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.HibernateUtil;

/**
 *
 * @author aristide
 */
public class StudentDaoNGTest {

    public StudentDaoNGTest() {
    }

    @BeforeTest
    public void init() {
        HibernateUtil.getSessionFactory();
    }

    @BeforeMethod
    public void initiateTest() {
        AbstractTestClass.execute(CommonOperation.POPULATE_ALL_TABLE);
    }

    @AfterMethod
    public void cleanTest() {
        AbstractTestClass.execute(CommonOperation.DELETE_ALL_ROW);
    }

    @Test
    public void testCreateStudent() {
        Student student = StudentDao.create(new Student(
                4,
                "21155",
                "GENERAL",
                Gender.FEMALE,
                LocalDate.of(1998, Month.MARCH, 1),
                "+250787011567",
                "g@gmail.com", new Department(1)));
        assertEquals(student.getVersion(), 1);

    }
    
    @Test
    public void testUpdateStudent() {
        Student student = StudentDao.update(new Student(
                1,
                "21155",
                "GENERAL",
                Gender.FEMALE,
                LocalDate.of(1998, Month.MARCH, 1),
                "+250787011567",
                "g@gmail.com", new Department(1)));
        assertEquals(student.getVersion(), 2);

    }
    
    @Test
    public void testDeleteStudent() {
        
        Student student = StudentDao.delete(new Student(3));
        assertEquals(student.getVersion(), 1);

    }

}
