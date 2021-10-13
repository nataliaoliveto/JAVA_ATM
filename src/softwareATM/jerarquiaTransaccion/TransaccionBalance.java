package softwareATM.jerarquiaTransaccion;

import softwareATM.Cuenta;

public class TransaccionBalance extends Transaccion{

	public TransaccionBalance() {
		super();
	}
	
	@Override
	public String setOperacion(Cuenta cuenta) {
		return 	"\nCuenta Nro: " + cuenta.getCNro() 
				+ "\nSu saldo es: $" + cuenta.getCSaldo()
				+ "\n****************************************";
	}
	
	public String toString() {
		return super.toString() + 
				"\nTipo: Solicitud de Saldo";
	}

}
