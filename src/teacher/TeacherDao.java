package teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeacherDao {

    
    public static void writeAttendance(Connection con, Teacher t, Integer id) throws SQLException {
        //writes attendance into database
        String query = "update Student set Present_Absent = '"+t.getAttendance()+"' where Roll_Number = "+id;
//        System.out.println(query);
        PreparedStatement st  = con.prepareStatement(query);
        st.executeUpdate();
    }

    public static  void writeEvent(Connection con,Teacher t,Integer id) throws SQLException
    {
        //writes event into database
        String query = "update Student set Participated_Event = '"+t.getEvent()+"' where Roll_Number = "+id;
//        System.out.println(query);
        PreparedStatement st  = con.prepareStatement(query);
        st.executeUpdate();


    }

    public static void main(String[] args) throws Exception{
        String url="jdbc:mysql://localhost:3306/ani";
        String uname="root";
        String pass="anirudh";
        String query="select * from studentsecurity";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Teacher t = new Teacher();
        t.setAttendance("P");
        t.setEvent("PaperPresentation");
        writeAttendance(con,t,13);
        writeEvent(con,t,13);

    }
}







