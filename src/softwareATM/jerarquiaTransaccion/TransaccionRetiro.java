package softwareATM.jerarquiaTransaccion;

import softwareATM.Cuenta;
import softwareATM.Fondos;

public class TransaccionRetiro extends Transaccion implements Fondos{

	private int trCantRetiro;
	
	public TransaccionRetiro(int trCantRetiro) {
		
		super();
		setTRCantRetiro(trCantRetiro);
	}
	
	public boolean validarFondos(int origen, int comparable) {
		
		boolean fondosOK = false;

		// Validamos que haya fondos suficientes en la cuenta, para hacer el retiro.
		if (origen >= comparable) {
			fondosOK = true;
		}
		
		return fondosOK;
	}

	public int getTRCantRetiro() {
		return trCantRetiro;
	}

	public void setTRCantRetiro(int trCantRetiro) {
		this.trCantRetiro = trCantRetiro;
	}
	
	@Override
	public String setOperacion(Cuenta cuenta) {
			
			cuenta.setCSaldo(cuenta.getCSaldo() - getTRCantRetiro());
			return "\nTransacción realizada con éxito!"
					+ "\nCuenta Nro: " + cuenta.getCNro() 
					+ "\nSaldo actual: $" + cuenta.getCSaldo()
					+ "\n****************************************";
	}
	
	public String toString() {
		return super.toString() + 
				"\nTipo: Retiro" + 
				"\nCantidad a retirar: $" + getTRCantRetiro();	
	}
	
}
