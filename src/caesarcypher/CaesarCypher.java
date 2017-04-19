package caesarcypher;





import java.io.IOException;
import java.math.BigInteger;

import javax.swing.JOptionPane;
import static caesarcypher.CaesarCypher.ALPHA;


public class CaesarCypher {

    public static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws IOException {
        
        while(true){

        String message = JOptionPane.showInputDialog("Enter the message");
        
        String f = JOptionPane.showInputDialog("1 to Encrypt \n2 to Decrypt");
        
        
        int flag = Integer.parseInt(f);
        switch(flag){
            case 1 :
            encryption e = new encryption();
            JOptionPane.showMessageDialog(null,e.encrypt(message, 3));
            break;
        
            case 2 :
            decryption d = new decryption();
            JOptionPane.showMessageDialog(null,d.decrypt(message, 3));
            break;
        

    }

    
        }
}
}

class encryption {

    public String encrypt(String message, int skey) {
        String plaintext = message.toLowerCase();
        String cyphertext = "";
        for (int i = 0; i < plaintext.length(); i++) {
            int charpos = ALPHA.indexOf(plaintext.charAt(i));
            int code = (skey * charpos) % 26;
            char replacedval = ALPHA.charAt(code);
            cyphertext = cyphertext + replacedval;
        }
        return cyphertext;
    }
}

class decryption {
    
     static BigInteger conv(int x){
            return BigInteger.valueOf(x);
        }

         
              
    public String decrypt(String cyphtext, int skey) {
        cyphtext = cyphtext.toLowerCase();
        
        BigInteger b1 = conv(skey);
        BigInteger b2 = new BigInteger("26");
        BigInteger b3 = b1.modInverse(b2);
        
        String str =  b3.toString();
        
        int newkey = Integer.parseInt(str);
    
        String plaintext = "";
        
        for (int i = 0; i < cyphtext.length(); i++) {
            int chapos = ALPHA.indexOf(cyphtext.charAt(i));
            int code = (chapos * newkey) % 26;
            if(code<0){
                code = ALPHA.length() +code;
            }
            char replacedval = ALPHA.charAt(code);
            plaintext = plaintext + replacedval;
        }
        return plaintext;
    }
}

