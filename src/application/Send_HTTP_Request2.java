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

		// add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");

		/*
		 * int responseCode = con.getResponseCode();
		 * System.out.println("\nSending 'GET' request to URL : " + url);
		 * System.out.println("Response Code : " + responseCode);
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		// print in String
		//System.out.println(response.toString());
		
		// Read JSON response and print
		JSONObject myResponse = new JSONObject(response.toString());

		String resposta = decifrar(myResponse);
		int NumeroCasas = myResponse.getInt("numero_casas");
		String token = myResponse.getString("token");
		String cifrado = myResponse.getString("cifrado");
		ResumoCriptografico rc = new ResumoCriptografico();
		String resultadoResumo = rc.criptografarMD5(resposta);

		SaidaPopularJSON(NumeroCasas, token, cifrado, resposta, resultadoResumo);

		
		System.out.println(resposta);
		

	}

	private static void SaidaPopularJSON(int numeroCasas, String token, String cifrado, String resposta,
			String resultadoResumo) throws JSONException {

		JSONObject my_obj = new JSONObject();
		my_obj.put("numero_casas", numeroCasas);
		my_obj.put("token", token);
		my_obj.put("cifrado", cifrado);
		my_obj.put("decifrado", resposta);
		my_obj.put("resumo_criptografico", resultadoResumo);

		

		salvarArquivo(my_obj);

	}

	private static void salvarArquivo(JSONObject myResponse) throws JSONException {

		/* SALVAR ARQUIVO */
		JSONObject myResult = new JSONObject(myResponse.toString());
		FileWriter writeFile = null;

		try {
			writeFile = new FileWriter("answer.json");
			// Escreve no arquivo conteudo do Objeto JSON
			writeFile.write(myResult.toString());
			writeFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static String decifrar(JSONObject myResponse) throws JSONException {

		Decifrar dc = new Decifrar();
		String cifrado = myResponse.getString("cifrado");
		int nroCasas = myResponse.getInt("numero_casas");
		System.out.println(cifrado);
		System.out.println("");
		String resposta2 = dc.criptografar(cifrado, nroCasas);

		return resposta2;
	}
}
