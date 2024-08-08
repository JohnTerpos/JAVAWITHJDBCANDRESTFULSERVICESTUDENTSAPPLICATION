package gr.uniwa.askisi1_db.service;

import gr.uniwa.askisi1_db.model.Students;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface StudentService {
    
    static final String RESULT_SUCCESS = "<h3>success</h3>";
    static final String RESULT_FAILURE = "<h3>failure</h3>";
    
    List<Students> getStudents();
    List<Students> getStudentsJson();
    Students getStudent(String lastname);
    String createStudent(String firstname,String lastname,String department,int semester,int passed_lessons,HttpServletResponse servletResponse);
    String updateStudent(String firstname,String lastname,String department,int semester,int passed_lessons, HttpServletResponse servletResponse);
    String deleteStudent(String lastname);
}
