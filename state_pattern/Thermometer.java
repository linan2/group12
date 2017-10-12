package state_pattern;

public class Thermometer {
	
	TemperatureState state;
	TemperatureState LowState,MiddleState,HightState;
	public void showMessage(){
		
		System.out.println("**************");
		state.showTemputer();
        System.out.print("****************");	
	
	}
	public void setState(TemperatureState state){
		
		this.state=state;
	}
	
 /*public TemperatureState getLowState(){
	 return LowState;
	 
	 
 }*/
 public TemperatureState getMiddleState(){
	 return MiddleState;
	 
	 
 }
 public TemperatureState getHightState(){
	 return HightState;
	 
	 
 }
}
