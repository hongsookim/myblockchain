package core;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class BlockChainStarter {
	  public static void main(String[] args) throws Exception{
		  KeyPairGenerator kpg;
		  kpg = KeyPairGenerator.getInstance("EC", "SunEC");
		  
		  KeyPair kp = kpg.genKeyPair();
		  PrivateKey privateKey = kp.getPrivate();
		  PublicKey publicKey = kp.getPublic();
		  
		  Signature ecdsa;
		  ecdsa = Signature.getInstance("SHA1withECDSA", "SunEC");
		  ecdsa.initSign(privateKey);
		  
		  String text = "Sent 100 coins from Lein to Kang";
		  String textInfected = "Sent 1000 coins from Lein to Kang";
		  System.out.println("Original Text: " + text);
		  System.out.println("Modified Original Text: " + textInfected);
		  
		  ecdsa.update(text.getBytes("UTF-8"));
		  byte[] signatureByte = ecdsa.sign();
		  System.out.println("Crypto Text: 0x" + (new BigInteger(1, signatureByte).toString(16)).toUpperCase());
		  
		  Signature signature;
		  signature = Signature.getInstance("SHA1withECDSA", "SunEC");
		  signature.initVerify(publicKey);
		  
		  //verify original text by public key
		  signature.update(text.getBytes("UTF-8"));
		  System.out.println("Verify Original Text: " + signature.verify(signatureByte));
		  
		  //verify modified original text by public key
		  signature.update(textInfected.getBytes("UTF-8"));
		  System.out.println("Verify modified Original Text: " + signature.verify(signatureByte));
		  
	  }
}
