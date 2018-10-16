package core;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import util.*;

public class BlockChainStarter {
	  public static void main(String[] args) throws Exception{
		  
		    Security.addProvider(new BouncyCastleProvider());
		    
		    EC ec = new EC();
		    ec.generate("private1.pem", "public1.pem");
		    ec.generate("private2.pem", "public2.pem");
			
		    PrivateKey privateKey1 = ec.readPrivateKeyFromPemFile("private1.pem");
		    PublicKey publicKey1 = ec.readPublicKeyFromPemFile("public1.pem");
		    PrivateKey privateKey2 = ec.readPrivateKeyFromPemFile("private2.pem");
		    PublicKey publicKey2 = ec.readPublicKeyFromPemFile("public2.pem");
			
		    Signature ecdsa;
		    ecdsa = Signature.getInstance("SHA1withECDSA");
		    ecdsa.initSign(privateKey1);

		    String text = "Plain Text";
		    System.out.println("Plain Text: " + text);
		    byte[] baText = text.getBytes("UTF-8");

		    ecdsa.update(baText);
		    byte[] baSignature = ecdsa.sign();
		    System.out.println("Signed Value: 0x" + (new BigInteger(1, baSignature).toString(16)).toUpperCase());

		    Signature signature;
		    signature = Signature.getInstance("SHA1withECDSA");
		    
		    signature.initVerify(publicKey1);	//test: publicKey2 ? false
		    signature.update(baText);
		    boolean result = signature.verify(baSignature);
		    
		    System.out.println("Verify: " + result);
	  }
}
