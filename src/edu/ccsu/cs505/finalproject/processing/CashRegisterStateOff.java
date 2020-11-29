package edu.ccsu.cs505.finalproject.processing;

/**
 * Represents Off state on cash registers, part of State pattern
 */
public class CashRegisterStateOff implements CashRegisterState{
	@Override
	public void powerPress(CashRegister register) {
		register.setPowerOn(true);
		register.setCashRegisterState(new CashRegisterStateLocked());
	}

	@Override
	public void lock(CashRegister register) {
		System.out.println("Cash Register is off.");
	}

	@Override
	public boolean unlock(String code, CashRegister register) {
		System.out.println("Cash Register is off.");
		return false;
	}

	@Override
	public boolean allowDeposit(Double amount, CashRegister register) {
		System.out.println("Cash Register is off.");
		return false;
	}

	@Override
	public boolean allowGetChange(Double amount, CashRegister register) {
		System.out.println("Cash Register is off.");
		return false;
	}

	@Override
	public void openDrawer(CashRegister cashRegister) {
		System.out.println("Cash Register is off.");
	}

	@Override
	public void closeDrawer(CashRegister cashRegister) {
		System.out.println("Cash Register is off.");
	}
}
