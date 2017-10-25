#include <OneWire.h>
#include <DallasTemperature.h>

// Data wire is plugged into port 2 on the Arduino
#define ONE_WIRE_BUS 2

// Setup a oneWire instance to communicate with any OneWire devices (not just Maxim/Dallas temperature ICs)
OneWire oneWire(ONE_WIRE_BUS);

// Pass our oneWire reference to Dallas Temperature. 
DallasTemperature sensors(&oneWire);

void setup(void)
{
  // start serial port
  Serial.begin(9600);
  Serial.println("Dallas Temperature IC Control Library Demo");

  // Start up the library
  sensors.begin();

  
/***********************************/
  for (int i=3; i<=7; i++)    //通过循环的方式设置2-7号引脚为输出状态
  {
    pinMode(i,OUTPUT);
  }
  /***********************************/
}

void loop(void)
{ 
    /***************显示版本信息********************/
  String rx_buffer;
rx_buffer=Serial.readString();

if (rx_buffer.startsWith("V"))  {
    Serial.println("SV2.5-HV2.0\r");
}
 /***************显示版本信息********************/
 /***************读取串口的数据********************/
 if(Serial.available() > 0)            //判断串口缓冲器是否有数据载入
 {
  int value = Serial.read();                      //读取串口数据
 
  /***************读取串口的数据********************/

 /***************读取串口的数据********************/
 /*******************做第一个动作****************/
 if(value = 1)
 {
  for (int x=3; x<=7; x++)   //通过循环的方式依次让每个引脚的led在1秒内完成明灭
  {
    digitalWrite(x,HIGH);
    delay(500);
    digitalWrite(x,LOW);
    delay(500);
  }
  }
   /*******************做第二个动作****************/
   if(value = 2)
 {
  for (int x=3; x<=7; x++)   //通过循环的方式依次让每个引脚的led在1秒内完成明灭
  {
    digitalWrite(x,HIGH);
    delay(300);
    digitalWrite(x,LOW);
    delay(300);
  }
  }
  /*******************做第三个动作****************/
    if(value = 3)
 {
  for (int x=3; x<=7; x++)   //通过循环的方式依次让每个引脚的led在1秒内完成明灭
  {
    digitalWrite(x,HIGH);
    delay(1000);
    digitalWrite(x,LOW);
    delay(100);
  }
  }
}    
  /***************读取串口的数据********************/

  
  /***************读取模拟口的值********************/

 // int n = analogRead(A0);    //可以读取A0口的电压值
  // Serial.println(n);                   //如果需要可以打印模拟口的值
    /***************读取并打印模拟口的值********************/
  /***************发光二极管循环闪烁********************/
 
 
   for (int x=3; x<=7; x++)   //通过循环的方式依次让每个引脚的led在1秒内完成明灭
  {
    digitalWrite(x,HIGH);
    delay(50);
    digitalWrite(x,LOW);
    delay(50);
  }
  /**************发光二极管循环闪烁*********************/
  // call sensors.requestTemperatures() to issue a global temperature 
  // request to all devices on the bus

  Serial.print("Requesting temperatures...");
  sensors.requestTemperatures(); // Send the command to get temperatures
  Serial.println("DONE");
  
  Serial.print("Temperature is: ");
  Serial.println(sensors.getTempCByIndex(0));  
}
