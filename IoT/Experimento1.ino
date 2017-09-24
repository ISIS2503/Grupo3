#include <SparkFunTSL2561.h>
#include <Wire.h>

SFE_TSL2561 light;

const int tempPin=A0; 
const int soundPin=A1;
const int coPin=A2;
const int ledPin = 13; 

const String tempUnit = "(*C)";
const String coUnit = "(PPM)";
const String sonUnit = "(dB)";
const String luUnit = "(Lux)";

int coPPM=0;
int tempC=0;
int sonDb=0;
int luzL=0;
boolean gain;     // Gain setting, 0 = X1, 1 = X16;
unsigned int ms;  // Integration ("shutter") time in milliseconds


String respArray[8] = {"","","","","","","",""};


void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  light.begin();
  unsigned char ID;
  
  if (light.getID(ID))
  {
    //Serial.print("Got factory ID: 0X");
    //Serial.print(ID,HEX);
    //Serial.println(", should be 0X5X");
  }
    else
  {
    byte error = light.getError();
    printError(error);
  }

  gain = 0;

  unsigned char time = 2;

  light.setTiming(gain,time,ms);

  light.setPowerUp();
  
  respArray[1] = String(tempUnit);
  respArray[3] = String(coUnit);
  respArray[5] = String(sonUnit);
  respArray[7] = String(luUnit);
  pinMode(tempPin,INPUT);
  pinMode(soundPin,INPUT);
  pinMode(coPin,INPUT);
  pinMode(ledPin, OUTPUT);
}

void loop() {
  unsigned int data0, data1;
    if (light.getData(data0,data1))
  {
    ms = 1000;
    double lux;    // Resulting lux value
    boolean good;  // True if neither sensor is saturated
    good = light.getLux(gain,ms,data0,data1,lux);
    luzL=(int)lux;
  }
    else
  {
    // getData() returned false because of an I2C error, inform the user.

    byte error = light.getError();
    printError(error);
  }
  digitalWrite(ledPin, HIGH);
  tempC = analogRead(tempPin);//dht.readTemperature();
  coPPM = analogRead(coPin);
  sonDb = analogRead(soundPin);
  tempC = (4.9 * tempC * 100.0)/1024.0;

  respArray[0] = String(tempC);
  respArray[2] = String(coPPM);
  respArray[4] = String(sonDb);
  respArray[6] = String(luzL);
  
  for (int i=0; i<8; i++){     
     // imprime el elemento del arreglo por el puerto serial
     Serial.print(respArray[i]);
     // espacio para diferenciar elementos en el arreglo
     Serial.print("\t");     
   }
   Serial.println("");
   delay(500);
   digitalWrite(ledPin, LOW);
   delay(500);
}

void printError(byte error)
  // If there's an I2C error, this function will
  // print out an explanation.
{
  /*Serial.print("I2C error: ");
  Serial.print(error,DEC);
  Serial.print(", ");
  
  switch(error)
  {
    case 0:
      Serial.println("success");
      break;
    case 1:
      Serial.println("data too long for transmit buffer");
      break;
    case 2:
      Serial.println("received NACK on address (disconnected?)");
      break;
    case 3:
      Serial.println("received NACK on data");
      break;
    case 4:
      Serial.println("other error");
      break;
    default:
      Serial.println("unknown error");
  }*/
}
