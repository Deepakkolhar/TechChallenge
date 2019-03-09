package ApicaPackage;
import Fillo.Fillo;
import Exception.FilloException;
import Fillo.Connection;
import Fillo.Recordset;


public class GetDataModule {

	public static String data_module(String GetData, Integer TCID) throws FilloException {

        Fillo fillo = new Fillo();
        Connection connect = fillo.getConnection("C:\\TestData\\MaintainUser.xls");
        String strQuery1 = "Select * from AddUser where TCID = " + TCID ;
        Recordset recordset1 = connect.executeQuery(strQuery1);
        recordset1.next();
        String ResultData = recordset1.getField(GetData);
        return ResultData;
        
    }

	  public static String data_module2(String GetData, Integer LOGINID) throws FilloException {

	        Fillo fillo = new Fillo();
	        Connection connect = fillo.getConnection("C:\\TestData\\MaintainUser.xls");
	        String strQuery2 = "Select * from Login where LOGINID = " + LOGINID ;
	        Recordset recordset2 = connect.executeQuery(strQuery2);
	        recordset2.next();
	        String ResultData = recordset2.getField(GetData);
	        return ResultData;

	    }
    
	  

		public static String data_module3(String GetData, Integer TCID) throws FilloException {

	        Fillo fillo = new Fillo();
	        Connection connect = fillo.getConnection("C:\\TestData\\MaintainUser.xls");
	        String strQuery3 = "Select * from DeleteUser where TCID = " + TCID ;
	        Recordset recordset3 = connect.executeQuery(strQuery3);
	        recordset3.next();
	        String ResultData = recordset3.getField(GetData);
	        return ResultData;
	        
	    }	    
	  
}
