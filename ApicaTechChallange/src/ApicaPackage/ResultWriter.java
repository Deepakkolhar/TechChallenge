package ApicaPackage;
import Exception.FilloException;
import Fillo.Fillo;
import Fillo.Connection;
import static java.lang.String.format;

public class ResultWriter {
	
	public static void writeResult(Integer TCID, String fieldName, String fieldValue) throws FilloException{
	
	Fillo fillo=new Fillo();
	Connection connection=fillo.getConnection("C:\\TestData\\MaintainUser.xls");	
	final String updateQuery = format("Update AddUser Set %s='%s' where TCID='%s'", fieldName, fieldValue, TCID);
  //  System.out.println("Executed Query is " + updateQuery);
    connection.executeUpdate(updateQuery);
	connection.close();
	}
	
	public static void writeResult2(Integer TCID, String fieldName, String fieldValue) throws FilloException{
		
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection("C:\\TestData\\MaintainUser.xls");	
		final String updateQuery2 = format("Update DeleteUser Set %s='%s' where TCID='%s'", fieldName, fieldValue, TCID);
	    System.out.println("Executed Query is " + updateQuery2);
	    connection.executeUpdate(updateQuery2);
		connection.close();
    }
}