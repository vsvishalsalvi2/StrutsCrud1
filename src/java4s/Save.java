package java4s;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;
public class Save extends ActionSupport{	
	private static final long serialVersionUID = 1L;
	
	Mybean mb=new Mybean();	
	
	public Mybean getMb() {
		return mb;
	}
	public void setMb(Mybean mb) {
		this.mb = mb;
	}


	public String execute()
	{
	
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver"); 
    java.sql.Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
	
	String s = "insert into details values(?,?,?)";	
	PreparedStatement ps=con.prepareStatement(s);
	ps.setInt(1, mb.getNo());
	ps.setString(2, mb.getNam());
	ps.setString(3, mb.getCt());
	
	ps.executeUpdate();
	con.commit();
	
		ps.close();  		
		con.close();

		    } 
		catch(Exception e){ 
 			e.printStackTrace(); 
 		}

		
			return SUCCESS;
		
	}
	
}
