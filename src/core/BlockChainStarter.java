package core;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import util.*;

public class BlockChainStarter {
	  public static void main(String[] args) throws Exception{
		  
		  Security.addProvider(new BouncyCastleProvider());
		  EC ec = new EC();
		  ec.generate("private.pem", "public.pem");
	  }
}
