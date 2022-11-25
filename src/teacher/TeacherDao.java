package teacher;

import student.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao extends Student {

    static int noOfStud = 0;
    static int length =0;
     static int len=0;  //UPDATED
    static int i=0; //UPDATED
    static int j=0;//UPDATED
    static List<Teacher> stud = new ArrayList<Teacher>();

    static List<Teacher> eventstud = new ArrayList<Teacher>();
    
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

        public static void getEvent(BufferedReader br,Connection con) throws IOException, SQLException {
        int i=len;
            while(i-->0)
            {
                System.out.println("Enter the rollno:");
                Integer rollno = Integer.parseInt(br.readLine());
              Teacher t = new Teacher();
                    System.out.println("Enter the event:");
                    String event = br.readLine();
                    t.setEvent(event);
                    writeEvent(con,t,rollno);
                    System.out.println("......................");


            }
        }

    public static void getPresent(BufferedReader br,Connection con) throws IOException, SQLException {
    int i=len;
        while(i-->0)
        {
            System.out.println("Enter the rollno:");
            Integer rollno = Integer.parseInt(br.readLine());
                Teacher t = new Teacher();
                System.out.println("Enter the attendence:");
                String event = br.readLine();
                t.setAttendance(event);
                writeAttendance(con,t,rollno);
                System.out.println("......................");
            }

        }




    public static void StudnetsPresent(Connection con) throws SQLException {
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
            noOfStud++;
            stud.add(t);

            //System.out.println("name :"+name+"  Intime "+inTime+"  outtime :"+outTime);
        }

    }
    static int inevent=0;
   public static void StudnetEvent(Connection con) throws SQLException {
        Statement st  = con.createStatement();
        String query = "select Name_of_Student,Participated_Event from Student where Participated_Event is NOT NULL";
        ResultSet rs = st.executeQuery(query);

        while(rs.next())
        {
            Teacher t = new Teacher();
        	String event =rs.getString("Participated_Event");
            String name = rs.getString("Name_of_Student");
            t.setName(name);
            t.setEvent(event);
       	    eventstud.add(t);
               inevent++;
       	 i++;
        }
    }
   
    public static void display()
    {
        int i= noOfStud;
        while(i-->0)
        {
            System.out.println("name: "+stud.get(i).getName()+" "+"  Intime: "+stud.get(i).getIntime()+"  OutTime: "+stud.get(i).getOuttime());
        }

    }
   
   public static void displayevent()
   {
       int i= inevent;
       while(i-->0)
       {
           System.out.println("name: "+eventstud.get(i).getName()+" "+"  Event : "+eventstud.get(i).getEvent());
       }

   }
    

    public  static void count(Connection con) throws SQLException {
        Statement st = con.createStatement();
        String query = "select count(Roll_Number) from Student";
        ResultSet rs = st.executeQuery(query);
        rs.next();
        len = rs.getInt("COUNT(Roll_Number)");


    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String url="jdbc:mysql://localhost:3306/ani";
        String uname="root";
        String pass="anirudh";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        while(true) {
            System.out.println("Enter the choice:");
            System.out.println("1) Enter the Attendence:");
            System.out.println("2) Enter the Event:");
            System.out.println("3) Display students who are Present:");
            System.out.println("4) Display students who participated in Event:");
            System.out.println("5) exit:");
            int choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    count(con);
                    getPresent(br, con);
                    //count(con);
                    break;
                case 2:
                    count(con);
                    getEvent(br, con);
                    break;
                case 3:
                    StudnetsPresent(con);
                    display();
                    break;
                case 4:
                    StudnetEvent(con);
                    displayevent();
                    break;
                case 5:
                    System.exit(0);


            }
        }



    }
}







