//#include <arduino.h>
//#include <SparkFunTSL2561.h>
#include <string.h>
#include <Wire.h>
//#define DHTTYPE DHT11

int coPin = 31;
int tempPin = 24;
int soundPin = 25;
//int luPin = 30;

int coPPM=0;
int tempC=0;
int sonDb=0;
int luzL=0;

//SFE_TSL2561 light;

String tempUnit = "(*C)";
String coUnit = "(PPM)";
String sonUnit = "(dB)";
String luUnit = "(Lux)";

String respArray[8] = {"","","","","","","",""};

int i = 0;

void setup()
{
  // join i2c bus with address #39
  //Wire.begin(8);
  //Wire.begin(9);
  Wire.begin(39);
  // register event 
  //Wire.onReceive(receiveEvent); 
  Serial.begin(9600);
  
  //light.begin();
  //light.setPowerUp();
  
  respArray[1] = String(tempUnit);
  respArray[3] = String(coUnit);
  respArray[5] = String(sonUnit);
  respArray[7] = String(luUnit);
  
  pinMode(soundPin,INPUT);
  
}

void loop()
{
  tempC = analogRead(tempPin);//dht.readTemperature();
  coPPM = analogRead(coPin);
  sonDb = analogRead(soundPin);
  
  Wire.onReceive(receiveEvent); 
  
  //luzL = Wire.read();
 
 if (light.getData(data0,data1))
  {
    // getData() returned true, communication was successful
    
    Serial.print("data0: ");
    Serial.print(data0);
    Serial.print(" data1: ");
    Serial.print(data1);
  }
  
  tempC = (4.9 * tempC * 100.0)/1024.0;
  
  respArray[0] = String(tempC);
  respArray[2] = String(coPPM);
  respArray[4] = String(sonDb);
  respArray[6] = String(luzL);
  //Wire.onReceive(receiveEvent); 
  
  for (i=0; i<8; i++){
     // imprime el elemento del arreglo por el puerto serial
     Serial.print(respArray[i]);
     // espacio para diferenciar elementos en el arreglo
     Serial.print("\t");     
   }
   Serial.println("");
   delay(1000);
}

// function that executes whenever data is received from master
// this function is registered as an event, see setup()
void receiveEvent(int howMany)
{
  // loop through all but the last
  while(1 < Wire.available()) 
  {
    // read byte as a character
    char c = Wire.read(); 
    Serial.print(c);  // print the character
  }
  // receive byte as an integer
  int x = Wire.read();
  //luzL = x;  
  Serial.println(x);  // print the integer
}
