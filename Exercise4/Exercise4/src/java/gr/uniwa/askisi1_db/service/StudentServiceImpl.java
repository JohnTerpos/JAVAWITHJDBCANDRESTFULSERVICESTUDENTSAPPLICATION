package gr.uniwa.askisi1_db.service;

import gr.uniwa.askisi1_db.database.StudentsDao;
import gr.uniwa.askisi1_db.model.Students;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/studentService")
public class StudentServiceImpl implements StudentService{
    
    StudentsDao studentDao=new StudentsDao();
    
    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public List<Students> getStudents() {
        return studentDao.getAllStudents();
    }
    
    @GET
    @Path("/studentsjson")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Students> getStudentsJson() {
        return studentDao.getAllStudents();
    }
    
    @GET
    @Path("/students/{studentlastname}")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public Students getStudent(@PathParam("studentlastname") String lastname) {
        return studentDao.getStudentbylastname(lastname);
    }

    @POST
    @Path("/students")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Override
    public String createStudent(@FormParam("firstname") String firstname,@FormParam("lastname") String lastname,@FormParam("department") String department,@FormParam("semester") int semester,@FormParam("passedlessons") int passed_lessons,@Context HttpServletResponse servletResponse) {
        Students student = new Students();
        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setDepartment(department);
        student.setSemester(semester);
        student.setPassed_lessons(passed_lessons);
        int result = studentDao.save(student);
        if (result == 1) {
            return RESULT_SUCCESS;
        }
        return RESULT_FAILURE;
    }

    @PUT
    @Path("/students")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Override
    public String updateStudent(@FormParam("firstname") String firstname,@FormParam("lastname") String lastname,@FormParam("department") String department,@FormParam("semester") int semester,@FormParam("passedlessons") int passed_lessons,@Context HttpServletResponse servletResponse) {
        Students student = new Students();
        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setDepartment(department);
        student.setSemester(semester);
        student.setPassed_lessons(passed_lessons);
        int result = studentDao.update(student);
        if (result == 1) {
            return RESULT_SUCCESS;
        }
        return RESULT_FAILURE;
    }

    @DELETE
    @Path("/students/{studentlastname}")
    @Produces(MediaType.TEXT_HTML)
    @Override
    public String deleteStudent(@PathParam("studentlastname") String lastname) {
        int result = studentDao.delete(lastname);
        if (result == 1) {
            return RESULT_SUCCESS;
        }
        return RESULT_FAILURE;
    }
    
}
