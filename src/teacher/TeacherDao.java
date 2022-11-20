package teacher;

import student.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao extends Student {

    static int noOfStud = 8;
     static int length=0; 
    static int i=0;
    static int j=0;
    static List<Teacher> stud = new ArrayList<Teacher>();

    static List<Teacher> studEvent  = new ArrayList<Teacher>();
    
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

    public static void displayStudnetsPresent(Connection con) throws SQLException {
        Statement st  = con.createStatement();
        String query = "select s.Name_of_Student,w.In_Time,w.Out_Time from Student s,Watchman w where s.Bus_Number=w.Bus_no and Present_Absent='P'";
        ResultSet rs = st.executeQuery(query);




        while(rs.next()) {
            Teacher t = new Teacher();
            String name = rs.getString("Name_of_Student");
            String inTime = rs.getString("In_Time");
            String outTime = rs.getString("Out_Time");
            t.setName(name);
            t.setAttendance("P");
            t.setIntime(inTime);
            t.setOuttime(outTime);

            stud.add(t);

            //System.out.println("name :"+name+"  Intime "+inTime+"  outtime :"+outTime);
        }

    }
      public static void StudnetEvent(Connection con) throws SQLException {
        Statement st  = con.createStatement();
        String query = "select name,event where event is NOT NULL";
        ResultSet rs = st.executeQuery(query);

        while(i<length)
        {
        	String event =rs.getString("Participated_Event");
       	 stud.get(i).setEvent(event);
       	 i++;
        }
    }
    public static void display()
    {
        int i= 3;
        while(i-->0)
        {
            System.out.println("name: "+stud.get(i).getName()+" "+"  Intime: "+stud.get(i).getIntime()+"  OutTime: "+stud.get(i).getOuttime());
        }

    }

    public static void main(String[] args) throws Exception{
        String url="jdbc:mysql://localhost:3306/ani";
        String uname="root";
        String pass="anirudh";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);

        displayStudnetsPresent(con);
        display();
//        Teacher t = new Teacher();
//        t.setAttendance("P");
//        t.setEvent("PaperPresentation");
//        writeAttendance(con,t,13);
//        writeEvent(con,t,13);

    }
}







