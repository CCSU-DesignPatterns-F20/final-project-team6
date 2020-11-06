package edu.ccsu.cs505.finalproject.processing;

public abstract class CashRegisterStateOn implements CashRegisterState{
	@Override
	public void powerPress(CashRegister register) {
		register.setPowerOn(false);
		register.setCashRegisterState(new CashRegisterStateOff());
	}

	@Override
	public void closeDrawer(CashRegister cashRegister) {
		cashRegister.operateDrawer(CashRegisterDrawerState.CLOSED);
	}
}
