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
		  
		    Security.addProvider(new BouncyCastleProvider());
	
		    Wallet wallet1 = new Wallet();
		    wallet1.setFromFile("private1.pem", "public1.pem");
		    Wallet wallet2 = new Wallet();
		    wallet2.setFromFile("private2.pem", "public2.pem");
		    Wallet wallet3 = new Wallet();
		    wallet3.setFromFile("private3.pem", "public3.pem");
		    
		    //blockID, previousBlockHash, nonce, transactionList
		    Block block1 = new Block( 1, null, 0, new ArrayList<Transaction>() );
		    block1.mine();
		    block1.showInformation();
		    
		    Block block2 = new Block(2, block1.getBlockHash(), 0, new ArrayList<Transaction>());
		    
		    //Create transaction to send from wallet1 to wallet2
		    Transaction transaction1 = new Transaction(wallet1, wallet2.getPublicKey(), 1.5, "2018-05-03 23:05:19.5");
		    block2.addTransaction(transaction1);
		    
		    //Create transaction to send from wallet2 to wallet3
		    Transaction transaction2 = new Transaction(wallet2, wallet3.getPublicKey(), 3.7, "2018-05-04 14:12:09.5");
		    block2.addTransaction(transaction2);
		    
		    block2.mine();
		    block2.showInformation();
		    
		    Block block3 = new Block(3, block2.getBlockHash(), 0, new ArrayList<Transaction>());

		    //Create transaction to send from wallet1 to wallet3
		    Transaction transaction3 = new Transaction(wallet1, wallet3.getPublicKey(), 2.3, "2018-05-06 17:09:21.5");
		    block3.addTransaction(transaction3);
		    
		    //Create transaction to send from wallet2 to wallet3
		    Transaction transaction4 = new Transaction(wallet2, wallet3.getPublicKey(), 1.4, "2018-05-07 02:11:19.5");
		    block3.addTransaction(transaction4);
		    
		    block3.mine();
		    block3.showInformation();
		  
	  }
}
