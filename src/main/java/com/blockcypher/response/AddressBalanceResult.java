package com.blockcypher.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressBalanceResult implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("total_received")
	private int totalReceived;
	
	@JsonProperty("total_sent")
	private int totalSent;
	
	@JsonProperty("balance")
	private int balance;
	
	@JsonProperty("unconfirmed_balance")
	private int unconfirmedBalance;
	
	@JsonProperty("final_balance")
	private int finalBalance;
	
	@JsonProperty("n_tx")
	private int tx;
	
	@JsonProperty("unconfirmed_n_tx")
	private int unconfirmedTx;
	
	@JsonProperty("final_n_tx")
	private int finalTx;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTotalReceived() {
		return totalReceived;
	}

	public void setTotalReceived(int totalReceived) {
		this.totalReceived = totalReceived;
	}

	public int getTotalSent() {
		return totalSent;
	}

	public void setTotalSent(int totalSent) {
		this.totalSent = totalSent;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getUnconfirmedBalance() {
		return unconfirmedBalance;
	}

	public void setUnconfirmedBalance(int unconfirmedBalance) {
		this.unconfirmedBalance = unconfirmedBalance;
	}

	public int getFinalBalance() {
		return finalBalance;
	}

	public void setFinalBalance(int finalBalance) {
		this.finalBalance = finalBalance;
	}

	public int getTx() {
		return tx;
	}

	public void setTx(int tx) {
		this.tx = tx;
	}

	public int getUnconfirmedTx() {
		return unconfirmedTx;
	}

	public void setUnconfirmedTx(int unconfirmedTx) {
		this.unconfirmedTx = unconfirmedTx;
	}

	public int getFinalTx() {
		return finalTx;
	}

	public void setFinalTx(int finalTx) {
		this.finalTx = finalTx;
	}
	
}
