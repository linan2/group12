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
		
		System.out.println("���ڵ��¶�"+n+"���ڵ��¶�");
	}
	
public void getfire(){
	
	System.out.print("����----�¶����");
}

}
