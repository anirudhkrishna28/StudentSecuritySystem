package teacher;

public class TeacherDao {
    
    public static void writeAttendance(Connection con,Teacher t,Integer id) throws SQLException {
        //writes attendance into database
        String query = "update studentsecurity set attendance = '"+t.getAttendance()+"' where rollno = "+id;
//        System.out.println(query);
        PreparedStatement st  = con.prepareStatement(query);
        st.executeUpdate();
    }

    public static  void writeEvent(Connection con,Teacher t,Integer id) throws SQLException
    {
        //writes event into database
        String query = "update studentsecurity set event = '"+t.getEvent()+"' where rollno = "+id;
//        System.out.println(query);
        PreparedStatement st  = con.prepareStatement(query);
        st.executeUpdate();


    }

    public static void main(String[] args) throws Exception{
        String url="jdbc:mysql://localhost:3306/test";
        String uname="root";
        String pass="Goniya030612#";
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







