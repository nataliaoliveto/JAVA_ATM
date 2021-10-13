package softwareATM.jerarquiaTransaccion;

import softwareATM.Cuenta;

public class TransaccionDeposito extends Transaccion{

	private int tdCantDeposito;
	
	public TransaccionDeposito(int tdCantDeposito) {
		
		super();
		setTDCantDeposito(tdCantDeposito);
	}

	public int getTDCantDeposito() {
		return tdCantDeposito;
	}

	public void setTDCantDeposito(int tdCantDeposito) {
		this.tdCantDeposito = tdCantDeposito;
	}

	@Override
	public String setOperacion(Cuenta cuenta) {								
		
		cuenta.setCSaldo(cuenta.getCSaldo() + getTDCantDeposito());
						
		return "\nA Cuenta Nro: " + cuenta.getCNro()
				+ "\nTransacci�n realizada con �xito!" 
				+ "\n****************************************";
	}
	
	public String toString() {
		return super.toString() + 
				"\nTipo: Dep�sito" + 
				"\nCantidad a depositar: $" + getTDCantDeposito();	
	}
	
}
