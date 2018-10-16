package core;

import util.*;

import java.util.ArrayList;
import java.math.BigInteger;
import java.security.Signature;

public class Block {
	private static final String ALGORITHM = "SHA1withECDSA";
	
	private int blockID;
	private String previousBlockHash;
	private int nonce;
	private ArrayList<Transaction> transactionList;

	public int getBlockID() {
	    return blockID;
	}

	public void setBlockID(int blockID) {
	    this.blockID = blockID;
	}

	public String getPreviousBlockHash() {
		  return previousBlockHash;
	}

	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}
	  
	public int getNonce() {
	    return nonce;
	}

	public void setNonce(int nonce) {
	    this.nonce = nonce;
	}

	public Block(int blockID, String previousBlockHash, int nonce, ArrayList<Transaction> transactionList) {
		this.blockID = blockID;
		this.previousBlockHash = previousBlockHash;
		this.nonce = nonce;
		this.transactionList = transactionList;
	}
	
	private boolean verifyTransaction(Transaction transaction) throws Exception {
		Signature signature;
		signature = Signature.getInstance(ALGORITHM);
		byte[] baText = transaction.getData().getBytes("UTF-8");
		signature.initVerify(transaction.getSender());
		signature.update(baText);
		return signature.verify(new BigInteger(transaction.getSignature(), 16).toByteArray());
	}
	
	public void addTransaction(Transaction transaction) throws Exception {
		if(verifyTransaction(transaction)) {
			System.out.println("Good Transaction!");
			transactionList.add(transaction);
		} else {
			System.out.println("Bad Transaction!");			
		}
		
	}

	  public void showInformation() {
		  System.out.println("--------------------------------------");
		  System.out.println("Block Number: " + getBlockID());
		  System.out.println("Previous Block Hash: " + getPreviousBlockHash());
		  System.out.println("Nonce: " + getNonce());
		  System.out.println("Transaction Number: " + transactionList.size());
		  for(int i = 0; i < transactionList.size(); i++) {
			  System.out.println(transactionList.get(i).getInformation());
		  }
		  System.out.println("Block Hash: " + getBlockHash());
		  System.out.println("--------------------------------------");
	  }

	  public String getBlockHash() {
		  String transactionInformations = "";
		  for(int i = 0; i < transactionList.size(); i++) {
		  	transactionInformations += transactionList.get(i).getInformation();
		  }

		  return Util.getHash(nonce + transactionInformations + previousBlockHash);	  
	  }
	  
	  public void mine() {
		  while(true) {
			  if(getBlockHash().substring(0, 4).equals("0000")) {
				  System.out.println("Success "+blockID+"th block mining.");
				  break;
			  }
			  nonce++;
		  }
	  }
}
