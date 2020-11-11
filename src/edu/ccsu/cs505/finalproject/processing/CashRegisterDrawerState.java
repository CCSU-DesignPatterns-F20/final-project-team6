package edu.ccsu.cs505.finalproject.processing;

/**
 * Enum of 2 possible cash drawer states
 */
public enum CashRegisterDrawerState {
	OPEN("open"),
	CLOSED("closed");

	private final String name;

	/**
	 * @param name
	 */
	private CashRegisterDrawerState(String name){
		this.name = name;
	}

	/**
	 * @return enum value
	 */
	public String toString(){
		return name;
	}
}
