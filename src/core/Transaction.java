package core;

public class Transaction {
	String sender;
	String receiver;
	double amount;

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getInformation() {
		return "Sent " + amount + " coins from " +sender+ " to "+receiver +"."; 
	}

	public Transaction( String sender, String receiver, double amount) throws Exception {
		this.sender = sender;
		this.receiver = receiver;
		this.amount = amount;
	}
}
