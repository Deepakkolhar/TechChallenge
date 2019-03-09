package ApicaPackage;

public class WaitClass { 
	
	public static void Waittime(int Waitetime){
		try {
			Thread.sleep(Waitetime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
