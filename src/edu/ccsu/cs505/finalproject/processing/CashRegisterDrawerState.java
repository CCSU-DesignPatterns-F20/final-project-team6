package edu.ccsu.cs505.finalproject.processing;

public enum CashRegisterDrawerState {
	OPEN("open"),
	CLOSED("closed");

	private final String name;

	private CashRegisterDrawerState(String name){
		this.name = name;
	}

	public String toString(){
		return name;
	}
}
