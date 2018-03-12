package db;

import java.sql.*;
import javax.swing.JOptionPane;

public class dbconnect{
    
    public static Connection cn;
    public static Statement st;
    public static PreparedStatement insertUser;
    public static PreparedStatement getUser;
    public static PreparedStatement updateUser;
    public static PreparedStatement deleteUser;
    public static PreparedStatement insertUser1;
    
    
    static{
    
        try{
            
              Class.forName("com.mysql.jdbc.Driver");
                cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/registrationdb","root","root");
                 st=cn.createStatement();
                 
                insertUser1= cn.prepareStatement("insert into ADMIN (username,pass,name)  values (?, ?, ?)");
                  
                insertUser = cn.prepareStatement("insert into REGISTRATION_ENTRIES (name,gender,dob,country,skills,address)  values (?, ?, ?, ?, ?, ? ) ");
                 
                 getUser = cn.prepareStatement("select * from REGISTRATION_ENTRIES where name like ? ");
                 
                 updateUser = cn.prepareStatement("update REGISTRATION_ENTRIES set name=? , gender=?,dob=?,country=?,skills=?,address=? where userid= ? "  );
                 
                 deleteUser = cn.prepareStatement("delete from REGISTRATION_ENTRIES where userid = ? ");
                
                 
        }catch(ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
