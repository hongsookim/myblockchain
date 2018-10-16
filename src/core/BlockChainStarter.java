package core;

import java.util.ArrayList;

public class BlockChainStarter {
	  public static void main(String[] args) throws Exception{
		  	Block block1 = new Block(1, null, 0, new ArrayList<Transaction>());
		    block1.mine();
		    block1.showInformation();
		    
		    Block block2 = new Block(2, block1.getBlockHash(), 0, new ArrayList<Transaction>());
		    block2.addTransaction(new Transaction("Nain", "Park", 1.5));
		    block2.addTransaction(new Transaction("Lein", "Park", 0.7));
		    block2.mine();
		    block2.showInformation();
		    
		    Block block3 = new Block(3, block2.getBlockHash(), 0, new ArrayList<Transaction>());
		    block3.addTransaction(new Transaction("Kain", "Lein", 8.2));
		    block3.addTransaction(new Transaction("Park", "Nain", 0.4));	//test: if 0.4 -> 9.9 ? to be change block information!
		    block3.mine();
		    block3.showInformation();

		    Block block4 = new Block(4, block3.getBlockHash(), 0, new ArrayList<Transaction>());
		    block4.addTransaction(new Transaction("Lein", "Kain", 0.1));
		    block4.mine();
		    block4.showInformation();
		  
	  }
}
