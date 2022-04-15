package Dao;

import model.Student;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDaoImplement implements StudentDao{
    static Connection con = DatabaseConnection.getConnection();

    @Override
    public int add(Student std) throws SQLException
    {

        String query = "insert into student(name, " + "student_id, " + " email, " + " password,  " + "section  ) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, std.getStd_name());
        ps.setString(2, std.getStd_id());
        ps.setString(3, std.getStd_email());
        ps.setString(4, std.getStd_pas());
        ps.setString(5, std.getStd_sec());
        int n = ps.executeUpdate();
        return n;
    }


    @Override
    public List<Student> getStudents() throws SQLException
    {
        String query = "select * from student";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Student> list = new ArrayList();

        while (rs.next()) {
            Student std = new Student();
            std.setStd_name(rs.getString("name"));
            std.setStd_id(rs.getString("student_id"));
            std.setStd_email(rs.getString("email"));
            std.setStd_pas(rs.getString("password"));
            std.setStd_sec(rs.getString("section"));
            list.add(std);
        }
        return list;
    }

    @Override
    public void update(String email,String sec)
            throws SQLException
    {
        String query = "update student set section=? where email = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, sec);
        ps.setString(2, email);
        ps.executeUpdate();
    }


}
