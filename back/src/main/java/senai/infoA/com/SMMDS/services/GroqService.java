package senai.infoA.com.SMMDS.services;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GroqService {

    // O Spring Boot vai ler automaticamente a chave que você colocou no application.properties
    @Value("${spring.ai.openai.api-key}")
    private String apiKey;

    private final String URL_GROQ = "https://api.groq.com/openai";

    public String pedirRecomendacaoAgricola(String tipoSensor, BigDecimal dadoLeitura, String tipoSolo) {
        try {
            // 1. Criamos o "cliente" que vai navegar na internet
            HttpClient cliente = HttpClient.newHttpClient();

            // 2. Definimos a "personalidade" da IA (Prompt do Sistema)
            String instrucaoIA = "Você é um engenheiro agrônomo especialista. "
                               + "Forneça uma recomendação curta, prática e direta (máximo de 15 palavras) "
                               + "de manejo ou irrigação baseado no sensor.";

            // 3. Montamos a pergunta com os dados reais do seu Arduino
            String perguntaUsuario = "O sensor " + tipoSensor + " marcou o valor " + dadoLeitura + "nesse tipo de solo" + tipoSolo + ". O que o agricultor deve fazer?";

            // 4. Montamos o texto no formato JSON que o Groq exige
            String corpoJson = "{"
                    + "\"model\": \"llama3-8b-8192\","
                    + "\"messages\": ["
                    + "  {\"role\": \"system\", \"content\": \"" + instrucaoIA + "\"},"
                    + "  {\"role\": \"user\", \"content\": \"" + perguntaUsuario + "\"}"
                    + "]"
                    + "}";

            // 5. Preparamos a viagem dos dados colocando a sua chave de segurança no cabeçalho (Header)
            HttpRequest requisicao = HttpRequest.newBuilder()
                    .uri(URI.create(URL_GROQ))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + apiKey)
                    .POST(HttpRequest.BodyPublishers.ofString(corpoJson, StandardCharsets.UTF_8))
                    .build();

            // 6. Fazemos a ligação web e aguardamos o Groq responder
            HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());

            // Se o servidor do Groq responder com sucesso (Status 200)
            if (resposta.statusCode() == 200) {
                return extrairTextoDaResposta(resposta.body());
            } else {
                return "Aviso: IA não está funcionando.";
            }

        } catch (Exception e) {
            return "Erro ao conectar com a IA: " + e.getMessage();
        }
    }

    // Método auxiliar para recortar o JSON e pegar apenas a frase de resposta da IA
    private String extrairTextoDaResposta(String jsonResposta) {
        try {
            int indexContent = jsonResposta.indexOf("\"content\":\"");
            if (indexContent != -1) {
                int inicio = indexContent + 11;
                int fim = jsonResposta.indexOf("\"", inicio);
                return jsonResposta.substring(inicio, fim)
                        .replace("\\n", " ")
                        .replace("\\\"", "\"");
            }
        } catch (Exception e) {}
        return "Leitura registrada.";
    }
}