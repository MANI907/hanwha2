package lab2;

public class LGTV implements TV{
	
	public void powerOn() {
		System.out.println(this.getClass().getSimpleName()+" Turn On LG TV");
	}
	
	public void powerOff() {
		System.out.println(this.getClass().getSimpleName()+" Turn Off");
	}
	
}
