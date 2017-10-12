package state_pattern;

public class MiddleState implements TemperatureState {

	
	double n=0;
	MiddleState(double n){
		
		if(n>0&&n<39)
			this.n=n;
		
	}
public void showTemputer(){
		
		System.out.println("现在的温度"+n+"属于低温度");
	}
}
