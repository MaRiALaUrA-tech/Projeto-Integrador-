int moistureValue;
/****************************************************************************
* DHT11 + Sensor de Umidade do Solo
* Mostra temperatura, umidade do ar e umidade do solo no Monitor Serial
****************************************************************************/

#include "DHT.h"

// DHT11
const int pino_dht = 9;
float temperatura;
float umidade;
DHT dht(pino_dht, DHT11);

// Sensor de umidade do solo
float moisture_percentage;

void setup()
{
  Serial.begin(9600);

  // Inicializa o DHT11
  dht.begin();
}

void loop()
{
  // Leitura do DHT11
  temperatura = dht.readTemperature();
  umidade = dht.readHumidity();

  // Leitura do sensor de umidade do solo
  moistureValue = analogRead(A0);
  moisture_percentage = ((moistureValue / 539.0) * 100);

  // Exibe dados do DHT11
  if (isnan(umidade) || isnan(temperatura))
  {
    Serial.println("Falha na leitura do Sensor DHT!");
  }
  else
  {
    Serial.print("Temperatura: ");
    Serial.print(temperatura);
    Serial.print(" *C");

    Serial.print(" | Umidade do Ar: ");
    Serial.print(umidade);
    Serial.print(" %");
  }

  // Exibe dados do sensor de umidade do solo
  Serial.print(" | Umidade do Solo: ");
  Serial.print(moisture_percentage);
  Serial.println(" %");

  delay(2000);
}