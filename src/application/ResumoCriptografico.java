package application;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ResumoCriptografico {

	static String criptografarMD5(String message)  throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		String senha = "admin";
		  
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
        String result = Arrays.toString(messageDigest);
        
         
        System.out.println(messageDigest);
        System.out.println(result);
		return result;

	}
	
	

}
