import java.sql.*;

public class TestingJDBC_Connection{
    public static void main (String[] args) {
        System.out.println();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse310lab01","root","root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("email"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        }

    }
