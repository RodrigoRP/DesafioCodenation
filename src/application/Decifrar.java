package application;



public class Decifrar {


	static String criptografar(String message, int nroCasas) {
		
		StringBuilder sb2 = new StringBuilder();
		char[] msg = message.toCharArray();
		String newMessage = message.toLowerCase();

		for (int j = msg.length; j > 0; j--) {
			
			char alpha = newMessage.charAt(j - 1);
			char beta = 0;			
	        boolean b1 = Character.isDigit(alpha); 
	        int ascii = (int) alpha + nroCasas;
	       
	        while (ascii > 122) {
	        	ascii = ((ascii - 122) + 96);
	        }
			
			if(b1) sb2.insert(0, alpha);
			else if(alpha !=' ' && alpha !='.' && alpha != 'x' && alpha != 'y' && alpha != 'z' ) {  
				beta = (char) (ascii);
			    sb2.insert(0, beta); 
			}
			else if(alpha == ' ') sb2.insert(0, ' ');
			else if(alpha == '.') sb2.insert(0, '.');
			else if(alpha == 'x') {
				if(ascii > 122) {
					sb2.insert(0, (char) ((ascii - 26) ));
				}
				else {
					sb2.insert(0, (char) ((ascii) ));
				}
			}
			else if(alpha == 'y') {
				if(ascii > 122) {
					sb2.insert(0, (char) ((ascii - 26) ));
				}
				else {
					sb2.insert(0, (char) ((ascii)  ));
				}
			}
			else if(alpha == 'z') sb2.insert(0, (char) ((122 - 26)  +  nroCasas ));
			//else if(alpha >= 0 || alpha <= 9)sb2.insert(0, alpha);
			
	
		}
		

		
		return sb2.toString();
	}

	

}
