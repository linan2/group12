package state_pattern;

public class LowState implements TemperatureState{
	Thermometer water;
	
	double n=0;
	LowState(double n){
		
		if(n<0)
			this.n=n;
		this.water=water;
		
	}
public void showTemputer(){
		
		System.out.println("现在的温度"+n+"属于低温度");
	}
	
public void getfire(){
	
	System.out.print("加热----温度身高");
}

}
