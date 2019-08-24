package application;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ResumoCriptografico {

	static String criptografarMD5(String message) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		/*
		 * MessageDigest algorithm = MessageDigest.getInstance("SHA-1"); byte
		 * messageDigest[] = algorithm.digest(message.getBytes("UTF-8")); String result
		 * = Arrays.toString(messageDigest);
		 * 
		 * System.out.println(messageDigest); System.out.println(result);
		 */
		String sha1 = "";

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			digest.update(message.getBytes("utf8"));
			sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * System.out.println("The sha1 of \"" + message + "\" is:");
		 * System.out.println(sha1); System.out.println();
		 */
		return sha1;

	}

}
