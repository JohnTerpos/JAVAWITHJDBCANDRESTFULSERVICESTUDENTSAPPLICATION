package gr.uniwa.askisi1_db.database;

import gr.uniwa.askisi1_db.model.Students;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsDao {
        public static Connection getConnection() {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/askisi1_db", "terpos", "spider18");
        } catch (ClassNotFoundException | SQLException ex) {           
        }
        return con;
    }
    
     public static int save(Students student) {
        int status = 0;
        Connection con = StudentsDao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO students (firstname, lastname, department, semester, passed_lessons) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1,student.getFirstname());  
            ps.setString(2,student.getLastname());  
            ps.setString(3,student.getDepartment());  
            ps.setInt(4,student.getSemester());
            ps.setInt(5,student.getPassed_lessons());
            status=ps.executeUpdate();                
            con.close();
        } catch (SQLException ex) {            
        }
        return status;
    }
     
      public static int update(Students student) {
        int status = 0;
        Connection con = StudentsDao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE students SET firstname=?, department=?, semester=?, passed_lessons=? WHERE lastname=?");
            ps.setString(1,student.getFirstname());  
            ps.setString(2,student.getDepartment());  
            ps.setInt(3,student.getSemester());
            ps.setInt(4,student.getPassed_lessons());
            ps.setString(5,student.getLastname()); 
            status=ps.executeUpdate();                
            con.close();
        } catch (SQLException ex) {            
        }
        return status;
    }
      
    public static int delete(String lastname) {
        int status = 0;
        Connection con = StudentsDao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE lastname=?");
            ps.setString(1,lastname);
            status=ps.executeUpdate();                
            con.close();
        } catch (SQLException ex) {            
        }
        return status;
    }
    
    public static Students getStudentbylastname(String lastname) {
        Students student=new Students();
        Connection con = StudentsDao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE lastname=?");
            ps.setString(1,lastname);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
              student.setFirstname(rs.getString(1));  
              student.setLastname(rs.getString(2));  
              student.setDepartment(rs.getString(3));  
              student.setSemester(rs.getInt(4));
              student.setPassed_lessons(rs.getInt(5));
            }
            con.close();
        } catch (SQLException ex) {            
        }
        return student;
    }
    
     public static List<Students> getAllStudents() {
        List<Students> list = new ArrayList<>();
        Connection con = StudentsDao.getConnection();  
        
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students");
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Students student= new Students();  
                student.setFirstname(rs.getString(1));
                student.setLastname(rs.getString(2));
                student.setDepartment(rs.getString(3));
                student.setSemester(rs.getInt(4));
                student.setPassed_lessons(rs.getInt(5));
                list.add(student);  
            }  
            con.close(); 
        } catch (SQLException ex) {
            
        }
        return list;
    }
}
