package SriParswam.AppleInc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AppleDAO {
	
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	        con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=AppleInc;", "DESKTOP-LJDH6C2\\SAI", "root" );  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}
    
    public List<AppleEmployees> listAllEmploys() throws SQLException {
        List<AppleEmployees> listEmploys = new ArrayList<>();
        
         
        try {
         
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("Select * from tblAppleEmployees");
        ResultSet resultSet = ps.executeQuery();
         
        while (resultSet.next()) {
            int Employid = resultSet.getInt("Employ_id");
            String EName = resultSet.getString("ENmae");
            String EDivision = resultSet.getString("EDivision");
            double EPhone = resultSet.getDouble("EPhone");
            String ESalary = resultSet.getString("ESalary");
            String EmployJob = resultSet.getString("EmployJob");
             
            AppleEmployees Employ = new AppleEmployees(Employid, EName, EDivision, ESalary, EPhone, EmployJob);
            listEmploys.add(Employ);
        }
         
        resultSet.close();
        con.close();
         
        }catch(Exception e) {System.out.println(e);}
         
        return listEmploys;
    }
    
    public AppleEmployees getEmploy(int Employid) throws SQLException {
        AppleEmployees Employ = null;
        
        try {
        	Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from tblAppleEmployees where Employid = ?");
            ResultSet resultSet = ps.executeQuery();             
         
        if (resultSet.next()) {
            String EName = resultSet.getString("ENmae");
            String EDivision = resultSet.getString("EDivision");
            double EPhone = resultSet.getDouble("EPhone");
            String ESalary = resultSet.getString("ESalary");
            String EmployJob = resultSet.getString("EmployJob");             
             
            Employ = new AppleEmployees(Employid, EName, EDivision, ESalary, EPhone, EmployJob);           
        }
         
        resultSet.close();
        con.close();
        
        }catch(Exception e) {System.out.println(e);}
         
        return Employ;
    } 
        
    public static int createEmploy(AppleEmployees Employ) throws SQLException {
    	int rowCreated = 0;
    	try {
        	Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("Insert INTO tblAppleEmployees(EName, EDivision, ESalary, EPhone, EmployJob) Values (?,?,?,?,?)");
            //ResultSet resultSet = ps.executeQuery();      
         
        ps.setString(1, Employ.getEName());
        ps.setString(2, Employ.getEDivision());
        ps.setDouble(3, Employ.getEPhone());
        ps.setString(2, Employ.getESalary());
        ps.setString(2, Employ.getEmployJob());
        
         
        rowCreated = ps.executeUpdate();
        ps.close();
        con.close();       
    	}catch (Exception e) {System.out.println(e);}
     
        return rowCreated;
    }
        
    public int updateBook(AppleEmployees Employ) throws SQLException {
        int rowUpdated = 0;
        try {
        	Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE Employ SET EName = ?, EDivision = ?, ESalary = ?, EPhone = ?, EmployJob = ?");
                     
        ps.setString(1, Employ.getEName());
        ps.setString(2, Employ.getEDivision());
        ps.setDouble(3, Employ.getEPhone());
        ps.setString(2, Employ.getESalary());
        ps.setString(2, Employ.getEmployJob());
         
        rowUpdated = ps.executeUpdate();
        ps.close();
        }catch (Exception e) {System.out.println(e);}
        return rowUpdated;     
    }
    
    public int deleteEmploy(AppleEmployees Employ) throws SQLException {
        int rowDeleted = 0;
        try {
        	Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM Employ where AppleEmploy_id = ?");
            
       
        ps.setInt(1, Employ.getEmployid());
         
        rowDeleted = ps.executeUpdate();
        ps.close();
        }catch (Exception e) {System.out.println(e);}
     
        return rowDeleted;     
    }   
      

}
