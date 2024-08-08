package gr.uniwa.askisi1_db.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
public class Students implements Serializable{
  private String firstname,lastname,department;
    private int semester,passed_lessons;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setPassed_lessons(int passed_lessons) {
        this.passed_lessons = passed_lessons;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDepartment() {
        return department;
    }

    public int getSemester() {
        return semester;
    }

    public int getPassed_lessons() {
        return passed_lessons;
    }  
}
