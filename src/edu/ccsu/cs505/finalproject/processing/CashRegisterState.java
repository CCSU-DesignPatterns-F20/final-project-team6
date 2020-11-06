package edu.ccsu.cs505.finalproject.processing;

public interface CashRegisterState {
	void powerPress(CashRegister register);
	void lock(CashRegister register);

	/**
	 * @param code to unlock cash register
	 * @param register to unlock
	 * @return true if register was unlocked successfully, false otherwise
	 */
	boolean unlock(String code, CashRegister register);
	boolean allowDeposit(Double amount, CashRegister register);
	boolean allowGetChange(Double amount, CashRegister register);
	void openDrawer(CashRegister cashRegister);
	void closeDrawer(CashRegister cashRegister);
}
