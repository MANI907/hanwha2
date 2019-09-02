package lab4;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;


//<bean id="car" class="lab4.Car" p:model="Stinger"/>
@Component("car2")
public class Car {
	//Field
	String model;
	int price;

	
	//Constructor
	
	public Car() {	}  // default Constructor
	
	
	public String getModel() {
		return model;
	}

	//모델명은 필수야
	//@Required
	public void setModel(String model) {
		this.model = model;
		
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public Car(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}


	@Override
	public String toString() {
		return "Car [model=" + model + ", price=" + price + "]";
	}


	
	
}
