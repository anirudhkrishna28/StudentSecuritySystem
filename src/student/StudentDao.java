package student;

import java.sql.*;

public class StudentDao extends Student {

        public void getAllStudentsDetails()
        {
            //display all records of students
        }

        //List<Student> allStudents  = new List<Student>();

        public void displayStudentsInEvents()
        {
            //displaying students involved in events
        }
        Integer count=0;
        public Integer countNoOfAbsentees()
        {
         return count;   //return absentees count
        }

 public static void main(String[] args)throws ClassNotFoundException, SQLException {
        //database connection
        String url="jdbc:mysql://localhost:3306/ani";
        String uname="root";
        String pass="anirudh";
        String query="select * from studentsecurity";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st  = con.createStatement();
        ResultSet rs = st.executeQuery(query);


        Student s = new Student();
            rs.next();
            Integer rollno = rs.getInt("rollno");
            String name = rs.getString("name");
            String dob = rs.getString("dob");
            Integer age = rs.getInt("age");

            s.setAge(age);
            s.setDob(dob);
            s.setStudId(rollno);
            s.setStudName(name);

            String stud = "name : "+s.getStudName()+"\n"+"rollno : "+s.getStudId()+"\n"+"DOB : "+s.getDob()+"\n"+"age : "+s.getAge();
        System.out.println(stud);
        System.out.println("------------------------------------------------------------------------------------------------------");
    }
}
