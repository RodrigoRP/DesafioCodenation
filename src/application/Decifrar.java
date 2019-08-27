package application;

public class Decifrar {

	public String criptografar(String message, int nroCasas) {

		StringBuilder sb = new StringBuilder();
		char[] msg = message.toCharArray();
		String newMessage = message.toLowerCase();

		for (int j = msg.length; j > 0; j--) {

			char alpha = newMessage.charAt(j - 1);
			char beta = 0;
			boolean b1 = Character.isDigit(alpha);
			int ascii = (int) alpha - nroCasas;

			while (ascii < 97 && b1 == false && alpha != ' ' && alpha !='.') {
				ascii = ((ascii + 122) - 96);
			}
			beta = (char) (ascii);
			if (b1)
				sb.insert(0, alpha);
			else if (alpha != ' ' && alpha != '.')
				sb.insert(0, beta);
			else 
				sb.insert(0, alpha);
			
				
		}

		return sb.toString();
	}

}
