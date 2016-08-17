package nmmu.wrap302.Task01;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by s214252914 on 2016/08/16.
 */
public class Students {
    ArrayList<Student> students = new ArrayList<Student>();

    public void registerStudent(Connection connection, String snr, String name, String surname, String res, boolean leadpos)
    {

        PreparedStatement statement = null;
        try{

            String sql = "INSERT INTO Student (studentNumber, Name, Surname, Res, leadershipPosition) " +
                    "VALUES (?,?,?,?,?)";

            statement = connection.prepareStatement(sql);
            statement.setString(1,snr);
            statement.setString(2,name);
            statement.setString(3,surname);
            statement.setString(4,res);
            statement.setBoolean(5,leadpos);
            statement.executeUpdate();

        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void populateStudents(Connection connection)
    {
        Statement statement = null;
        try{
            statement = connection.createStatement();
            String sql = "SELECT * FROM Student";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next())
            {
                String snr = resultSet.getString("studentNumber");
                String name = resultSet.getString("Name");
                String sname = resultSet.getString("Surname");
                String res = resultSet.getString("Res");
                Boolean leadpos = resultSet.getBoolean("leaderPosition");
                students.add(new Student(name,sname, res,leadpos,snr));
            }
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


}
