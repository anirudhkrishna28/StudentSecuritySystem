package watchman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WatchManDao {

    static List<WatchMan> watchmen = new ArrayList<WatchMan>();
    public static void writeIntime(Connection con,WatchMan w,Integer busno) throws SQLException {
        //writes intime into database
        String query = "update bus set intime = '"+w.getInTime()+"' where busno = "+busno;
//        System.out.println(query);
        PreparedStatement st  = con.prepareStatement(query);
        st.executeUpdate();
    }

    public static void BusIntime( Connection con,BufferedReader br) throws SQLException, IOException {
        System.out.println("ENTER THE IN TIME OF BUSSES \n");
        int noOfBus = 3;
        int i=0;
        while(i<noOfBus)
        {
            WatchMan w = new WatchMan();
            System.out.print("Enter the bus no:");
            Integer busno = Integer.parseInt(br.readLine());

            System.out.print("Enter the Intime:");
            String intime =br.readLine();
            w.setInTime(intime);
            watchmen.add(w);
            writeIntime(con, w, busno);
            i++;

        }
    }

    public static void BusOuttime( Connection con,BufferedReader br) throws SQLException, IOException {
        System.out.println("ENTER THE OUT TIME OF BUSSES \n");
        int noOfBus = 3;
        int i=0;
        while(i<noOfBus)
        {
            WatchMan w = new WatchMan();
            System.out.print("Enter the bus no:");
            Integer busno = Integer.parseInt(br.readLine());

            System.out.print("Enter the outtime:");
            String intime =br.readLine();

            watchmen.get(i).setOutTime(intime);
            watchmen.get(i).setBusNO(busno);
            writeOuttime(con, watchmen.get(i), busno);
            i++;

        }
    }

    public static  void writeOuttime(Connection con,WatchMan w,Integer busno) throws SQLException
    {
        //writes Outtime into database
        String query = "update bus set outtime = '"+w.getOutTime()+"' where busno = "+busno;
//        System.out.println(query);
        PreparedStatement st  = con.prepareStatement(query);
        st.executeUpdate();


    }
public static void busDetails()
{
    System.out.println();
    int i=3;
    while(i-->0)

    System.out.println("Bus no:"+watchmen.get(i).getBusNO()+"  Intime: "+watchmen.get(i).getInTime()+"   OutTime :"+watchmen.get(i).getOutTime()+"\n");
}
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String url="jdbc:mysql://localhost:3306/ani";
        String uname="root";
        String pass="anirudh";
        String query="select * from studentsecurity";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        BusIntime(con,br);
        BusOuttime(con,br);

        busDetails();
    }
}


