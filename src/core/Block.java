package core;

import util.*;

public class Block {
	private int blockID;
	private String previousBlockHash;
	private int nonce;
	private String data;

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
	
	public String getData() {
		return data;
	}
	  
	public void setData(String data) {
		this.data = data;
	}

	public Block(int blockID, String previousBlockHash, int nonce, String data) {
		this.blockID = blockID;
		this.previousBlockHash = previousBlockHash;
		this.nonce = nonce;
		this.data = data;
	}
	
	public void getInformation() {
		System.out.println("--------------------------------------");
		System.out.println("Block Number: " + getBlockID());
		System.out.println("Previous Block Hash: " + getPreviousBlockHash());
		System.out.println("Nonce: " + getNonce());
		System.out.println("Block Data: " + getData());
		System.out.println("Block Hash: " + getBlockHash());
		System.out.println("--------------------------------------");
	}

  	public String getBlockHash() {
  		return Util.getHash(nonce + data + previousBlockHash);	  
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
