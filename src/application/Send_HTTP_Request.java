package application;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;

public class Send_HTTP_Request {
	public static void main(String[] args) {
     try {
         Send_HTTP_Request.call_me();
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
     System.out.println("\nSending 'GET' request to URL : " + url);
     System.out.println("Response Code : " + responseCode);
     BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
     String inputLine;
     StringBuffer response = new StringBuffer();
     while ((inputLine = in.readLine()) != null) {
     	response.append(inputLine);
     }
     in.close();
     //print in String
     System.out.println(response.toString());
     //Read JSON response and print
		/*
		 * JSONObject myResponse = new JSONObject(response.toString());
		 * System.out.println("result after Reading JSON Response");
		 * System.out.println("statusCode- "+myResponse.getString("numero_casas"));
		 * System.out.println("statusMessage- "+myResponse.getString("token"));
		 * System.out.println("ipAddress- "+myResponse.getString("cifrado"));
		 * System.out.println("countryCode- "+myResponse.getString("decifrado"));
		 * System.out.println("countryName- "+myResponse.getString(
		 * "resumo_criptografico"));
		 */
     JSONObject myResponse = new JSONObject();
     myResponse = response.toString();
     
     
     
     FileWriter writeFile = null;
     
     
     try{
         writeFile = new FileWriter("saida.json");
         //Escreve no arquivo conteudo do Objeto JSON
         writeFile.write(response.toString());
         writeFile.close();
     }
     catch(IOException e){
         e.printStackTrace();
     }
      
    
   }
}