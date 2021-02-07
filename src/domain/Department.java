 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

/**
 *
 * @author aristide
 */
@Entity
public class Department implements Serializable {

    @ManyToOne
    private Faculty faculty;

    @Id
    private int id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    
    @OneToMany(mappedBy = "department")
    private List<Student> students;
    
    @OneToMany(mappedBy = "department")
    private List<Course> courses;
    
    @Version
    private long version = 1;

    public Department() {
    }

    public Department(int id) {
        this.id = id;
    }

    public Department(Faculty faculty, int id, String name) {
        this.faculty = faculty;
        this.id = id;
        this.name = name;
    }
    

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
    
}
