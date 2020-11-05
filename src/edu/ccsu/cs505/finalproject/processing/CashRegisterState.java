package edu.ccsu.cs505.finalproject.processing;

public interface CashRegisterState {
	void powerPress();
	void lock();
	void unlock();
	void depositCash();
	void getChange();
}
