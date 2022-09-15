/**
 * 
 */
package com.lti.bean;

/**
 * @author Nikhil, Luca
 *
 */
public class Payment {
	private int paymentID;
	private Student payer;
	private double amountPaid;
	
	/**
	 * @return the paymentID
	 */
	public int getPaymentID() {
		return paymentID;
	}
	/**
	 * @param paymentID the paymentID to set
	 */
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	/**
	 * @return the payer
	 */
	public Student getPayer() {
		return payer;
	}
	/**
	 * @param payer the payer to set
	 */
	public void setPayer(Student payer) {
		this.payer = payer;
	}
	/**
	 * @return the amountPaid
	 */
	public double getAmountPaid() {
		return amountPaid;
	}
	/**
	 * @param amountPaid the amountPaid to set
	 */
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	
}
