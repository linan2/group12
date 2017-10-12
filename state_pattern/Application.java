package state_pattern;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TemperatureState state=new LowState(-12);//定义借口对象
		 Thermometer th=new Thermometer();//申明运行环境，，运行环境有实现借口类的方法
		             th.setState(state);//环境与  具体类绑定
		              th.showMessage();//运行接口类的方法
	
}

	

}
//状态牧师可以在 实现借口的类中实现  状态的转换，，

//在运行环境中  第一不同的状态，，并给出get 方法  和    *****借口的  set 方法***
//在接口类中给出状态变换的方法
//在实现接口类  的类中在状态转换方法中，，设置不同的状态转化


/*
 * public void getfire(){
 *  接口类对象
 * 
 * }
 * 
 * */
 