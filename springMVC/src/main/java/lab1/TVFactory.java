package lab1;

public class TVFactory {
	
	//method
	public static TV makeTV(String brand) {
		TV tv = null;
		
		if(brand.equals("sam")) {
			tv = new SamsungTV();
			
		} else if(brand.equals("lg")) {
			tv = new LGTV();
		}
		
		return tv;
	}
}
