package SriParswam.AppleInc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppleEmployees {
	protected int Employid;
	protected String EName;
	protected String EDivision;
	protected String ESalary;
	protected Double EPhone;
	protected String EmployJob;
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {		    
	    
		
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=AppleInc;", "sairamparswam", "AZaz09$$" );  
        
  
        PreparedStatement ps = con.prepareStatement(" select * from tblAppleEmployees ");
        
        ResultSet resultSet = ps.executeQuery();
        
        List<AppleEmployees> listEmploys = new ArrayList<>();
        
        while (resultSet.next()) {
            int Employid = resultSet.getInt("Employ_id");
            String EName = resultSet.getString("ENmae");
            String EDivision = resultSet.getString("EDivision");
            double EPhone = resultSet.getDouble("EPhone");
            String ESalary = resultSet.getString("ESalary");
            String EmployJob = resultSet.getString("EmployJob");
             
            AppleEmployees Employ = new AppleEmployees(Employid, EName, EDivision, ESalary, EPhone, EmployJob);
            listEmploys.add(Employ);}
        
        resultSet.close();
        con.close();
        
	}
	
	
        
        
        public AppleEmployees() {
		
		
	}
	
	public AppleEmployees(int Employid) {
		this.Employid = Employid;
	}
	
	public AppleEmployees(int Employid, String EName, String EDivision, String ESalary, double EPhone, String EmployJob) {
		this(EName, EDivision, ESalary, EPhone, EmployJob);
		this.Employid = Employid;
	}
	
	public AppleEmployees(String EName, String EDivision, String ESalary, Double EPhone, String EmployJob) {
		this.EName = EName;
		this.EDivision = EDivision;
		this.ESalary = ESalary;
		this.EPhone = EPhone;
		this.EmployJob = EmployJob;
	}

	public int getEmployid() {
		return Employid;
	}

	public void setEmployid(int employid) {
		Employid = employid;
	}

	public String getEName() {
		return EName;
	}

	public void setEName(String eName) {
		EName = eName;
	}

	public String getEDivision() {
		return EDivision;
	}

	public void setEDivision(String eDivision) {
		EDivision = eDivision;
	}

	public String getESalary() {
		return ESalary;
	}

	public void setESalary(String eSalary) {
		ESalary = eSalary;
	}

	public Double getEPhone() {
		return EPhone;
	}

	public void setEPhone(Double ePhone) {
		EPhone = ePhone;
	}

	public String getEmployJob() {
		return EmployJob;
	}

	public void setEmployJob(String employJob) {
		EmployJob = employJob;
	}	
	
	

}

