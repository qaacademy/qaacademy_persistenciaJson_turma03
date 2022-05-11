import com.google.gson.Gson;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TesteJson {
    static Map<String, String> dadosTesteMap = new HashMap<String, String>(); //Criação do Map para abrigar o json
    static Gson gson = new Gson();// Biblioteca do Google para fazer manupulação de json.
    static Reader reader; //Leitura de arquivos do sistema para o Java.

    public static void main(String[] args) throws IOException {
        leituraJson();
        escritaArquivoJson();

    }

    public static void leituraJson() throws FileNotFoundException {

        reader = new FileReader("./src/main/resources/massaTeste.json"); // Faz a leitudo do de sistema para o Java
        dadosTesteMap = gson.fromJson(reader, Map.class);

        System.out.println(dadosTesteMap.get("url"));
        System.out.println(dadosTesteMap.get("produto"));
        System.out.println(dadosTesteMap.get("valor"));
    }

    public static void escritaArquivoJson() throws IOException {
        dadosTesteMap.put("email", "teste@teste.com.br");
        dadosTesteMap.put("senha", "teste@123");

        FileWriter writer = new FileWriter("./src/main/resources/copia_massaTeste.json");
        gson.toJson(dadosTesteMap, writer);
        writer.flush();
        writer.close();

    }
}
