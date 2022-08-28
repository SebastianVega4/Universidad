package logic;

import java.time.LocalDate;
import java.time.Month;
import logic.Account;

public class Account {
	private String number;
	private String nameCustomer;
	private LocalDate dateOpen;
	private Double residue;
	private int numberTransactions;
	static double RESIDUE_MIN = 50_000;
	private int typeAccount;

	public Account() {

	}

	public Account(String number, String nameCustomer, LocalDate dateOpen, Double residue) {
		this.number = number;
		this.nameCustomer = nameCustomer;
		this.dateOpen = dateOpen;
		this.residue = residue;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public Double getResidue() {
		return residue;
	}

	public int getNumberTransactions() {
		return numberTransactions;
	}

	public double consign(double consign) {
		residue += consign;
		return residue;
	}

	public boolean withdraw(double value) {
		if (value <= residue - RESIDUE_MIN) {
			residue -= value;
			numberTransactions++;
			return true;
		} else {
			return false;
		}

	}

	public boolean transfer(double consign, boolean bolean, Account ant) {
		return true;
	}

	public String toString() {

		return super.toString();
	}

}
