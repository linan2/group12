package state_pattern;

public class HightState implements TemperatureState {

	double n=39;
	HightState(){
	if(n>=39)
		this.n=n;
	
	}
	public void showTemputer(){
		
		System.out.println("现在的温度"+n+"属于低温度");

	}
}
