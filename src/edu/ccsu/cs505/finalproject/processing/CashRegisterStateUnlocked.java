package edu.ccsu.cs505.finalproject.processing;

/**
 * Represents On-Unlocked state on cash registers, part of State pattern
 */
public class CashRegisterStateUnlocked extends CashRegisterStateOn{
	@Override
	public void lock(CashRegister register) {
		register.setCashRegisterState(new CashRegisterStateUnlocked());
		System.out.println("Cash Register is locked");
	}

	@Override
	public boolean unlock(String code, CashRegister register) {
		System.out.println("Cash Register is already unlocked");
		return true;
	}

	@Override
	public boolean allowDeposit(Double amount, CashRegister register) {
		return true;
	}

	@Override
	public boolean allowGetChange(Double amount, CashRegister register) {
		if(amount < register.getBalance())
		{
			return true;
		}
		else
		{
			System.out.println("Cash Register does not have enough funds.");
			return false;
		}
	}

	@Override
	public void openDrawer(CashRegister cashRegister) {
		cashRegister.operateDrawer(CashRegisterDrawerState.OPEN);
	}
}
