package edu.ccsu.cs505.finalproject.processing;

/**
 * Interface for cash register states, part of State pattern
 */
public interface CashRegisterState {
	void powerPress(CashRegister register);
	void lock(CashRegister register);

	/**
	 * @param code to unlock cash register
	 * @param register to unlock
	 * @return true if register was unlocked successfully, false otherwise
	 */
	boolean unlock(String code, CashRegister register);

	/**
	 * A gatekeeper for deposit functionality
	 * @param amount to deposit
	 * @param register to deposit money to
	 * @return true if the current state object allow depositing, false otherwise
	 */
	boolean allowDeposit(Double amount, CashRegister register);

	/**
	 * A gatekeeper for withdrawal functionality
	 * @param amount amount to withdraw
	 * @param register to withdraw money from
	 * @return true if the current state object allow withdrawing, false otherwise
	 */
	boolean allowGetChange(Double amount, CashRegister register);

	/**
	 * @param cashRegister register to open drawer of
	 */
	void openDrawer(CashRegister cashRegister);

	/**
	 * @param cashRegister register to closed drawer of
	 */
	void closeDrawer(CashRegister cashRegister);
}
