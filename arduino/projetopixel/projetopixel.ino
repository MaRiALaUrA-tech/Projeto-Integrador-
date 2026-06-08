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

  moistureValue = analogRead(A0);
  
  // Mapeia o valor analógico para porcentagem (invertendo se necessário)
  // Nota: Geralmente solo seco dá valor alto e solo úmido dá valor baixo no analogRead.
  // Se o valor estiver invertido, ajuste o cálculo.
  moisture_percentage = (100.0 - ((moistureValue / 1023.0) * 100.0));

  // Envia os dados exatamente no padrão que o Java espera:
  if (!isnan(temperatura) && !isnan(umidade))
  {
    // Envia a temperatura (Ex: TEMP_AR:25.5;)
    Serial.print("TEMP_AR:");
    Serial.print(temperatura);
    Serial.print(";");

    // Envia a umidade do ar (Ex: UMID_AR:60.0;)
    Serial.print("UMID_AR:");
    Serial.print(umidade);
    Serial.print(";");
  }

  // Envia a umidade do solo (Ex: UMID_SOLO:45.2;)
  Serial.print("UMID_SOLO:");
  Serial.print(moisture_percentage);
  Serial.println(";"); // O último precisa ser println para o Java saber que a linha acabou

  delay(5000); // 5 segundos de intervalo está ótimo para monitoramento agrícola
}