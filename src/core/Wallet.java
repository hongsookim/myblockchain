package core;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

import util.EC;

public class Wallet {
	private static final String ALGORITHM = "SHA1withECDSA";
	
	private PrivateKey privateKey;
	private PublicKey publicKey;
	
	public PrivateKey getPrivateKey() {
		return privateKey;
	}
	
	public PublicKey getPublicKey() {
		return publicKey;
	}
	
	public void setFromFile(String privateKey, String publicKey) throws Exception{
		this.privateKey = new EC().readPrivateKeyFromPemFile(privateKey);
		this.publicKey = new EC().readPublicKeyFromPemFile(publicKey);
	}
	
	public String sign(String data) throws Exception {
		Signature signature;
		signature = Signature.getInstance(ALGORITHM);
		signature.initSign(privateKey);
		
		byte[] baText = data.getBytes("UTF-8");
		signature.update(baText);
		
		byte[] baSignature = signature.sign();
		
		return (new BigInteger(1, baSignature).toString(16)).toUpperCase();
	}
}
