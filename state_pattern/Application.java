package state_pattern;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TemperatureState state=new LowState(-12);//�����ڶ���
		 Thermometer th=new Thermometer();//�������л����������л�����ʵ�ֽ����ķ���
		             th.setState(state);//������  �������
		              th.showMessage();//���нӿ���ķ���
	
}

	

}
//״̬��ʦ������ ʵ�ֽ�ڵ�����ʵ��  ״̬��ת������

//�����л�����  ��һ��ͬ��״̬����������get ����  ��    *****��ڵ�  set ����***
//�ڽӿ����и���״̬�任�ķ���
//��ʵ�ֽӿ���  ��������״̬ת�������У������ò�ͬ��״̬ת��


/*
 * public void getfire(){
 *  �ӿ������
 * 
 * }
 * 
 * */
 