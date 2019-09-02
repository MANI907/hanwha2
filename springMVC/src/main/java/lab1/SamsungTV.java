package lab1;

public class SamsungTV implements TV{
	
	public void powerOn() {
		System.out.println(this.getClass().getSimpleName()+" Turn On");
	}
	
	public void powerOff() {
		System.out.println(this.getClass().getSimpleName()+" Turn Off");
	}
	
}
