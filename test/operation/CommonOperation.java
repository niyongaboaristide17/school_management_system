/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation;

import com.ninja_squad.dbsetup.operation.Operation;
import static com.ninja_squad.dbsetup.Operations.*;

/**
 *
 * @author aristide
 */
public class CommonOperation {
    public static final Operation DELETE_ALL_ROW = sequenceOf(
            deleteAllFrom("course_student"),
            deleteAllFrom("STUDENT"),
            deleteAllFrom("COURSE"),
            deleteAllFrom("DEPARTMENT"),
            deleteAllFrom("FACULTY")
    );
    
    public static final Operation POPULATE_ALL_TABLE = sequenceOf(
            // id |          name 
            insertInto("FACULTY")
                    .withDefaultValue("version", 1)
                    .columns("id","name")
                    .values(1,"FACULTY 1")
                    .values(2,"FACULTY 2")
                    .values(3,"FACULTY 3")
                    .build(),
            // id | name | faculty_id
            insertInto("DEPARTMENT")
                    .withDefaultValue("version", 1)
                    .columns("id","name", "faculty_id")
                    .values(1,"DEPART 1", 1)
                    .values(2,"DEPART 2", 2)
                    .values(3,"DEPART 3", 1)
                    .build(),
            //id | dateofbirth | emailaddress | gender | name | phonenumber | studentid | department_id 
            insertInto("STUDENT")
                    .withDefaultValue("version", 1)
                    .columns("id", "emailaddress", "gender", "name","phonenumber","studentid", "department_id")
                    .values(1,"niyongaboaristide17@gmail.com","MALE","Aristide","+250787011567","21090", 1)
                    .values(2, "niyongaboaristide17@gmail.com","MALE","NIYONGABO","+250787011567","21064",2)
                    .values(3, "niyongaboaristide17@gmail.com",1,"FEMALE","+250787011567","21148",1)
                    .build(),
            // id | code | credits | name | department_id 
            insertInto("COURSE")
                    .withDefaultValue("version", 1)
                    .columns("id","code","credits","name","department_id")
                    .values(1,"code1", 3,"JAVA", 3)
                    .values(2,"code2", 4,"PYTHON", 1)
                    .values(3,"code3", 3,"C#", 1)
                    .build(),
            // id | course_id | student_id 
            insertInto("course_student")
                    .columns("courses_id","students_id")
                    .values(1,1)
                    .values(1,2)
                    .values(2,2)
                    .build()
    );
    
}
