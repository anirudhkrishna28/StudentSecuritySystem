package watchman;

import java.sql.*;

public class WatchManDao {

    public static void writeIntime(Connection con,WatchMan w,Integer id) throws SQLException {
        //writes intime into database
        String query = "update studentsecurity set intime = '"+w.getInTime()+"' where rollno = "+id;
//        System.out.println(query);
        PreparedStatement st  = con.prepareStatement(query);
        st.executeUpdate();
    }

    public static  void writeOuttime(Connection con,WatchMan w,Integer id) throws SQLException
    {
        //writes Outtime into database
        String query = "update studentsecurity set outtime = '"+w.getOutTime()+"' where rollno = "+id;
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
        WatchMan w = new WatchMan();
        w.setInTime("8:50 AM");
        w.setOutTime("4:11 PM");
        writeIntime(con,w,13);
        writeOuttime(con,w,13);

    }
}
