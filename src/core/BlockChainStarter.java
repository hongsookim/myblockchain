package core;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import util.*;

public class BlockChainStarter {
	  public static void main(String[] args) throws Exception{
		  System.out.println(Util.getHash("0"));		  
	  }
}
