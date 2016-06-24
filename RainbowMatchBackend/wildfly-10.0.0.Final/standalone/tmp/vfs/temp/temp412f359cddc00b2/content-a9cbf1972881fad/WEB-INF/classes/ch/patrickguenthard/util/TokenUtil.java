package ch.patrickguenthard.util;

import java.util.Random;
import ch.patrickguenthard.constants.Constants;

public class TokenUtil {
    
    
    public static String createToken(){
	Random rand = new Random();
	String token = "";
	//for(int i = 0; i < Constants.TOKEN_LENGTH; i++) {
	//    token +=  Constants.TOKEN_COMBINATION_STRING.charAt(rand.nextInt(Constants.TOKEN_COMBINATION_STRING.length()));
	//}
	return token;
	
    }
}
