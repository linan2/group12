/*

 作用:使用arduino模拟口测量室内温度
 
*/
void setup() {
  Serial.begin(9600);         //使用9600速率进行串口通讯
   Serial.println("I have ready");        //
}

void loop() {

  int n0 = analogRead(A0);    //读取A0口的电压值
  int n1 = analogRead(A1);    //读取A1口的电压值
   int n2 = analogRead(A2);    //读取A2口的电压值
   int n3 = analogRead(A3);    //读取A3口的电压值
  float vol = n0 * (5.0 / 1023.0*100);   //使用浮点数存储温度数据，温度数据由电压值换算得到

  Serial.println(vol);                   //串口输出温度数据
 Serial.println(n1);                   //串口输出n1
  Serial.println(n2);                   //串口输出n2
   Serial.println(n3);                   //串口输出n3
  delay(2000);                           //等待2秒，控制刷新速度

  
  if(Serial.available() > 0)            //判断串口缓冲器是否有数据载入
  {
    int value;
    int ctrl0=4;                                //控制模拟4口的输出
    int ctrl1=5;                                //控制模拟5口的输出
    int ctrl2=6;                                //控制模拟6口的输出
    int ctrl3=7;                                //控制模拟7口的输出
  value = Serial.read();                      //读取串口数据
  analogWrite(ctrl0,value);
   analogWrite(ctrl1,value);
    analogWrite(ctrl2,value);
     analogWrite(ctrl3,value);
  Serial.println("OK! You have sended a message!Your english is very bad!!!!");
  delay(10);
  }
}



