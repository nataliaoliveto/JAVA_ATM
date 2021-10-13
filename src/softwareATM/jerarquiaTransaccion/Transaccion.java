package softwareATM.jerarquiaTransaccion;

import java.text.SimpleDateFormat;
import softwareATM.Cuenta;

public abstract class Transaccion {
	
	// El n�mero de transacci�n es static ya que pertenece a la clase y no cambia su valor por instancia.
	protected static int tId = 0;
	protected String tHorario;
	
	public Transaccion() {
		setTId(getTId() + 1); //aumenta el n�mero de transacci�n (clase) cada nueva instancia.
		setTHorario();
	}

	public static int getTId() {
		return tId;
	}

	public static void setTId(int tId) {
		Transaccion.tId = tId;
	}

	public String getTHorario() {
		return tHorario;
	}

	public void setTHorario() {
				
		// Con el horario actual, establecemos el horario de la transacci�n.
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		tHorario = formatter.format(System.currentTimeMillis());
	}
		
	public abstract String setOperacion(Cuenta cuenta);
	
	public String toString() {
		return 	"****************************************" + 
				"\nN�mero de Transacci�n: " + getTId() +
				"\nHorario: " + getTHorario();
	}
		
}
