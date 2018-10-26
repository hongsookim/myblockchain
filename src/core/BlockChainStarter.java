package core;

import util.*;

public class BlockChainStarter {
	  public static void main(String[] args) throws Exception{
		    int nonce = 0;
		    while(true) {
		    	System.out.println("Hashed Value: " + Util.getHash(nonce + ""));
			    //Difficuly? It's up and down due to the number of zero
			    if(Util.getHash(nonce + "").substring(0, 6).equals("000000")) {
			        System.out.println("Answer: " + nonce);
			        break;
			    }
			    nonce++;
		    }	  
	  }
}
