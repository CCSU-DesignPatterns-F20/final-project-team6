package edu.ccsu.cs505.finalproject.processing;

/**
 * Represents On-Locked state on cash registers, part of State pattern
 */
public class CashRegisterStateLocked extends CashRegisterStateOn{
	@Override
	public void lock(CashRegister register) {
		System.out.println("Cash Register is already locked");
	}

	@Override
	public boolean unlock(String code, CashRegister register) {
		if(code.equalsIgnoreCase("1234")){
			System.out.println("Code accepted.");
			register.setCashRegisterState(new CashRegisterStateUnlocked());
			System.out.println("Cash Register is unlocked.");
			return true;
		}
		else{
			System.out.println("Invalid code, try again...");
			return false;
		}
	}

	@Override
	public boolean allowDeposit(Double amount, CashRegister register) {
		System.out.println("Cash Register is locked, unlock before depositing.");
		return false;
	}

	@Override
	public boolean allowGetChange(Double amount, CashRegister register) {
		System.out.println("Cash Register is locked, unlock before getting change.");
		return false;
	}

	@Override
	public void openDrawer(CashRegister cashRegister) {
		System.out.println("Cash Register is locked, unlock before opening.");
	}
}
