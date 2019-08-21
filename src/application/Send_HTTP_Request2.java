package application;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class Send_HTTP_Request2 {
	public static void main(String[] args) {
     try {
         Send_HTTP_Request2.call_me();
        } catch (Exception e) {
         e.printStackTrace();
       }
     }
	   
public static void call_me() throws Exception {
     String url = "https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=d519fcd95f419217e64cd5dca131972033e300d8";
     URL obj = new URL(url);
     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     // optional default is GET
     con.setRequestMethod("GET");
     //add request header
     con.setRequestProperty("User-Agent", "Mozilla/5.0");
     int responseCode = con.getResponseCode();
     //System.out.println("\nSending 'GET' request to URL : " + url);
     //System.out.println("Response Code : " + responseCode);
     BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
     String inputLine;
     StringBuffer response = new StringBuffer();
     while ((inputLine = in.readLine()) != null) {
     	response.append(inputLine);
     }
     in.close();
     //print in String
     //System.out.println(response.toString());
     //Read JSON response and print
     JSONObject myResponse = new JSONObject(response.toString());
     
		/*
		 * System.out.println("")
		 * System.out.println("result after Reading JSON Response");
		 * System.out.println("numero_casas: "+myResponse.getInt("numero_casas"));
		 * System.out.println("token: "+myResponse.getString("token"));
		 * System.out.println("cifrado: "+myResponse.getString("cifrado"));
		 * System.out.println("decifrado: "+myResponse.getString("decifrado"));
		 * System.out.println("resumo_criptografico: "+myResponse.getString(
		 * "resumo_criptografico"));
		 */
     
     String resposta = decifrar(myResponse);
     System.out.println(resposta);
     salvarArquivo(myResponse);

   }

private static void salvarArquivo(JSONObject myResponse) {

	/* SALVAR ARQUIVO */
	FileWriter writeFile = null;
	
    try{
        writeFile = new FileWriter("saida.json");
        //Escreve no arquivo conteudo do Objeto JSON
        writeFile.write(myResponse.toString());
        writeFile.close();
    }
    catch(IOException e){
        e.printStackTrace();
    }
	
}

private static String decifrar(JSONObject myResponse) throws JSONException {
	
	Decifrar dc = new Decifrar();
	String cifrado = myResponse.getString("cifrado");
	int nroCasas = myResponse.getInt("numero_casas");
	String resposta2 = dc.criptografar("ftq bdanxqy iuft fdagnxqetaafuzs ue ftmf fdagnxq etaafe nmow. gzwzaiz mgftad", 20);
	//ftq bdanxqy iuft fdagnxqetaafuzs ue ftmf fdagnxq etaafe nmow. gzwzaiz mgftad

	return resposta2;
}
}