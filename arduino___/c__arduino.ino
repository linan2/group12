
char CMD;           //command
int pwmValue;       //PWM value
int PinOUT=10;      //output pin
int Interval = 10;

void setup()
{
  Serial.begin(9600);
  pinMode(PinOUT, OUTPUT);    //set the pin 10 as output pin
  CMD = 'F';
  pwmValue = 50;
}
void loop()
{
  if (Serial.available())
  {
    char PrevCMD;
    PrevCMD = CMD;
    CMD = Serial.read();
    switch(CMD)
    {
    case 'B':   //Blink
      //read PWM value in readPWMValue routine
      pwmValue = readPWMValue();
      break ;
      //any other CASE statement
    case 'F':   //Fading
      pwmValue = readPWMValue();
      break;
    default :
      CMD = PrevCMD; //当没有按键或者控制指令无效时，继续执行原来的指令
      break;
    }
  }

  //if there is no chars income, then execute the last command
  switch(CMD)
  {
  case 'B':
    setPWM(pwmValue);
    break;
  case 'F':
    ledFading(pwmValue);
    break;

  default:
    break;
  }
}
int readPWMValue()
{  
  int Value;
  while (!Serial.available())
  {
    //wait for another incoming char
  }
  Value=Serial.read();

  Serial.print("Parameters received: ");
  Serial.println(Value);

  return Value;
}
void setPWM(int Value)
{
  int i;

  Serial.println(Value);

  for (i=0; i<=100; i++)
  {  
    //debug
    Serial.print(i);
    Serial.print(" / ");
    if (i<= Value)
    {
      digitalWrite(PinOUT,HIGH);

      //Debug
      Serial.println("HIGH");
    }
    else
    {
      digitalWrite(PinOUT,LOW);

      //DEBUG
      Serial.println("LOW");
    }
    delay(Interval);
  }
}
void ledFading(int Value)
{  
  Serial.print("Fading Value: ");
  Serial.println(Value);
  int i;
  /*
    if (Value>=255)
   Value = 255;
   else
   if (Value<=0);
   Value =0;
   */

  //fade in
  for (i=0; i<=Value; i++)
  {
    analogWrite(PinOUT, i);
    Serial.println(i);
    delay(Interval);
  }

  delay(500);

  //fade out
  for (i=Value; i>=0; i--)
  {
    analogWrite(PinOUT,i);
    Serial.println(i);
    delay(Interval);
  }

  delay(500);

}






