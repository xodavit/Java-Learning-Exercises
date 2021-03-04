package request;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetRequest {
    //подключив в мавен 5 версию http-clienta в нем по умолчанию был логер slf4j и на старте программы, оно крашилось с ошибкой.
    //SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
    //SLF4J: Defaulting to no-operation (NOP) logger implementation
    //SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
    // очень долго возился,не понял как в intellij idea  добавить что-то в класспасс и где это вообще и что от меня хотят,
    // переделал на более старую и всего с 1 зависимостью. для этой работы хватило
    //
    static String sURL = "https://speller.yandex.net/services/spellservice";
    static String sPARAM = "/checkText?text=";
    static String sTEXT_RESPONSE = "москва+виликая+оизина+диржнавы+ношей";//значение москва тоже не бло поменяно на -с большой буквы

    // "синхрафазатрон+в+дубне";
    //в итоге на выходе у меня получается синхрофазатрон, синхрофазотрон, синхрофазотроне.
    //а вот дубне на Дубне не поменяло :(
    public static void main(String[] args) {

        try (CloseableHttpClient httpClient = HttpClients.createDefault())
        {
            HttpGet httpGet = new HttpGet(sURL+sPARAM+sTEXT_RESPONSE);
            try {
                CloseableHttpResponse response = httpClient.execute(httpGet);
                System.out.println(EntityUtils.toString(response.getEntity()));

            }catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
