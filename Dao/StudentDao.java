package Dao;
import model.Student;
import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    public int add(Student std) throws SQLException;
    public List<Student> getStudents() throws SQLException;
    public void update(String a, String b)  throws SQLException;
}
