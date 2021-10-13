package softwareATM;

import hardware.*;
import softwareATM.jerarquiaTransaccion.*;
import java.util.ArrayList;

public class Atm implements Fondos{	

	private Pantalla aPantalla;
	private Teclado aTeclado;
	private Dispensador aDispensador;
	private Ranura aRanura;
	private ArrayList<Usuario> aBaseDeDatos;
	private int aIndexUsuarioLogeado;
	private ArrayList<Transaccion> aLogTransaccion;
	
	public Atm(ArrayList<Usuario> aBaseDeDatos) {
		
		aPantalla = new Pantalla(15);
		aTeclado = new Teclado("Acero");
		aDispensador = new Dispensador();
		aRanura = new Ranura();
		setABaseDeDatos(aBaseDeDatos);
		setAIndexUsuarioLogeado(-1);
		aLogTransaccion = new ArrayList<Transaccion>();
		
	}
	
	public void logear() {

		aPantalla.mostrarPMensaje("Bienvenida/o al ATM!" 
								+ "\nPor favor, ingrese su Número de Cuenta.", 1);
		
		setAIndexUsuarioLogeado(ingresarNroCuenta(true));	
		ingresarNip();		
		operar();	 
	}
	
	public void operar() {
		
		int opcion = 0;
		boolean opcionValida = false;
		int importe = 0;
		boolean fondosAtmOk = false;
		boolean fondoCuentaOK = false;	
		
		aPantalla.mostrarPMensaje(aBaseDeDatos.get(aIndexUsuarioLogeado).getUNombre()
								+ ", ¿Qué operación desea realizar?"
								+ "\n\tIngrese 1 para Solicitud de Saldo."
								+ "\n\tIngrese 2 para Realizar un Retiro."
								+ "\n\tIngrese 3 para Realizar un Depósito."
								+ "\n\tIngrese 4 para Salir del Sistema.");				
				
		while(!opcionValida) {
			
			opcion = aTeclado.recibirDatos();			
				
			switch (opcion) {
			
				case 1:	// Solicitud de Saldo
						Transaccion consulta = new TransaccionBalance(); 
						
						aPantalla.mostrarPMensaje(consulta
								+ consulta.setOperacion(aBaseDeDatos.get(aIndexUsuarioLogeado).getUCuenta()));
						
						aLogTransaccion.add(consulta);
						operar();
						break;
					
				case 2:	// Retiro
						
						// Validamos que el Dispensador tenga fondos para retirar.
						fondosAtmOk = validarFondos(getADispensador().getDEfectivo(), 1);
						if (fondosAtmOk) {
							aPantalla.mostrarPMensaje("Ingrese el importe a retirar");
							
							do{
								importe = aTeclado.recibirDatos();
								
								// Validamos que el importe a retirar sea distinto a 0 y múltiplo de 20.
								if (importe == 0 || importe % 20 != 0) {
									
									aPantalla.mostrarPMensaje("El importe a retirar debe ser mayor a $0 y "
											+ "múltiplo de $20. \nIngrese nuevamente el importe a retirar");
								}
								
							} while(importe == 0 || importe % 20 != 0);
							
							// Validamos que el Dispensador del ATM tenga fondos suficientes
							// para realizar la transacción, según el importe ingresado.
							fondosAtmOk = validarFondos(getADispensador().getDEfectivo(), importe);
							if (fondosAtmOk) {
								
								Transaccion retiro = new TransaccionRetiro(importe);
								
								if (retiro instanceof TransaccionRetiro) {
									TransaccionRetiro retiroT = (TransaccionRetiro) retiro;
									
									int saldoUsuario = (int) aBaseDeDatos.get(aIndexUsuarioLogeado).getUCuenta().getCSaldo();
									// Convertimos el saldo de la cuenta del usuario (double) 
									// a un entero, ya que el ATM sólo dispensa efectivo (int)
									fondoCuentaOK = retiroT.validarFondos(saldoUsuario, importe);
								}
								
								if(fondoCuentaOK){
									aDispensador.entregarEfectivo(importe);
									aPantalla.mostrarPMensaje(retiro
											+ retiro.setOperacion(aBaseDeDatos.get(aIndexUsuarioLogeado).getUCuenta()));
									aLogTransaccion.add(retiro);
								}else {
									aPantalla.mostrarPMensaje("\n****************************************"
											+ "\nError en la Transacción: "
											+ "\nFondos insuficientes"
											+ "\nPuede ingresar 1 para Solicitar su Saldo"
											+ "\n****************************************");
								}
							
							} else {	
							// El Dispensador del ATM no tiene fondos suficientes para realizar el retiro.
							// El usuario puede realizar una nueva operación.
								aPantalla.mostrarPMensaje("El ATM no dispone de los fondos que usted desea "
										+ "retirar.\nInténtelo más tarde o elija una cifra menor.");
							}														
						
						} else {
							// El Dispensador del ATM no tiene fondos y no se puede retirar dinero.
							// El usuario puede realizar una nueva operación.
							
							aPantalla.mostrarPMensaje("El ATM no cuenta con fondos disponibles, "
									+ "por favor, diríjase a otro.");							
						}
	
						operar();
						break;
						
				case 3:	// Depósito
						
						int opcionD = 0;
						boolean opcionValidaD = false;
						int aIndexDeposito = 0;
						
						aPantalla.mostrarPMensaje("¿Qué tipo de depósito desea realizar?"
								+ "\nIngrese 1 para Depósito a Cuenta propia."
								+ "\nIngrese 2 para Depósito a Cuenta de terceros.");
						
						while(!opcionValidaD) {
							
							opcionD = aTeclado.recibirDatos();			
							
							switch (opcionD) {
							
								case 1: // Si el depósito es a Cuenta propia
									aIndexDeposito = aIndexUsuarioLogeado;
									opcionValidaD = true;
									break;
									
								case 2: // Si el depósito es a Cuenta de terceros, debe ingresar el Nro de Cuenta
									aPantalla.mostrarPMensaje("Ingrese el número de Cuenta Destino: ");
									aIndexDeposito = ingresarNroCuenta(false);
									opcionValidaD = true;
									break;
									
								default: 
									aPantalla.mostrarPMensaje("La opción ingresada es inválida."
											+ "\nIngrese 1 para Depósito a Cuenta propia."
											+ "\nIngrese 2 para Depósito a Cuenta de terceros.");
									break;
							}
						}
					
						aPantalla.mostrarPMensaje("Ingrese el importe a depositar");
						
						do{
							importe = aTeclado.recibirDatos();
							
							if (importe == 0) {
								aPantalla.mostrarPMensaje("El importe a depositar debe ser mayor a $0."
										+ "\nIngrese nuevamente el importe a depositar");
							}
							
						} while(importe == 0);
						
						aRanura.setRCantRecibida(importe);
						Transaccion deposito = new TransaccionDeposito(aRanura.getRCantRecibida()); 				
						aDispensador.recibirEfectivo(aRanura.getRCantRecibida());
						aPantalla.mostrarPMensaje(deposito
								+ deposito.setOperacion(aBaseDeDatos.get(aIndexDeposito).getUCuenta()));
						aLogTransaccion.add(deposito);										
						operar();
						break;
						
				case 4:	// Salir del Sistema
					
						aPantalla.mostrarPMensaje("Muchas gracias por elegirnos, " 
								+ aBaseDeDatos.get(aIndexUsuarioLogeado).getUNombre() + "!\n");					
						
						setAIndexUsuarioLogeado(-1);	// Deslogeamos al usuario
						logear();
						break;
	
				default: // Opción inválida
					
						aPantalla.mostrarPMensaje("La opción ingresada es inválida."
								+ "\n\tIngrese 1 para Solicitud de Saldo."
								+ "\n\tIngrese 2 para Realizar un Retiro."
								+ "\n\tIngrese 3 para Realizar un Depósito."
								+ "\n\tIngrese 4 para Salir del Sistema.");
						break;
			}						
		}					
	}
	
	public int ingresarNroCuenta(boolean isLogin) {
		
		int nroCuenta = 0;
		boolean cuentaValida = false;
		int indexCuenta = 0;
		
		// Ingreso y validación de número de cuenta
		while (!cuentaValida) {
			
			nroCuenta = aTeclado.recibirDatos();
			
			// Validamos que el número de cuenta ingresado tenga cinco dígitos
			if (nroCuenta >= 10000 && nroCuenta <= 99999) {
				
				// Validamos que la Cuenta ingresada por el Usuario sea válida.
				for (int i = 0; i < aBaseDeDatos.size(); i++) {
					
					// La Cuenta ingresada por el Usuario es válida. 
					if (aBaseDeDatos.get(i).getUCuenta().getCNro() == nroCuenta) {
						
						// Si es login, validamos que la Cuenta NO esté bloqueada.
						// Si es un depósito, no es necesario validar si la cuenta está bloqueada.
						// En ambos casos, guardamos el índice.
						if ((isLogin && !aBaseDeDatos.get(i).getUCuenta().getCBloqueada()) || !isLogin) {
							
							cuentaValida = true;
							indexCuenta = i;
							break;
							
						} else {
							// La cuenta está bloqueada, mostramos un mensaje en pantalla 
							// y volvemos a la pantalla de Login.
							
							aPantalla.mostrarPMensaje("La Cuenta está bloqueada, por favor, diríjase "
									+ "a una sucursal para regularizar su situación.\n");	
							
							logear();
						}						
					}					
				}
				
				// Si la Cuenta ingresada por el Usuario NO es válida.
				if (!cuentaValida) {	
					
					aPantalla.mostrarPMensaje("El Número de Cuenta ingresado no pertenece a un "
							+ "Usuario existente.\nPor favor, ingrese su Número de Cuenta.");
				} 								
				
			} else {
				// El Numero de Cuenta ingresado no tiene cinco dígitos. 
				// Mostramos mensaje de error en pantalla. 								
				
				aPantalla.mostrarPMensaje("El Número de Cuenta debe tener cinco dígitos."
						+ "\nPor favor, ingrese nuevamente su Número de Cuenta.");				
			}					
		}
		return indexCuenta;		
	}
	
	public void ingresarNip() {
		
		int cantidadIntentos = 0;
		int nroNip = 0;
		boolean nipValido = false;
		
		aPantalla.mostrarPMensaje("Por favor, ingrese su NIP.");
		
		// Ingreso y validación del NIP. Al tercer intento fallido, bloqueamos la Cuenta.
		while (!nipValido) {
			
			nroNip = aTeclado.recibirDatos();					
			
			// Validamos que el NIP ingresado tenga cinco dígitos.
			if (nroNip >= 10000 && nroNip <= 99999) {
				
				// Validamos que el NIP ingresado coincida con el de la cuenta logeada.
				if (aBaseDeDatos.get(aIndexUsuarioLogeado).getUCuenta().getCNip() == nroNip) {
					
					nipValido = true;
					
				} else {
					// El NIP ingresado no coincide con el de la cuenta logeada.
					
					cantidadIntentos++;
					
					// Mostrarmos mensaje de ingreso erróneo de NIP. 
					// Al tercer intento fallido, bloqueamos la Cuenta.   
					if(cantidadIntentos < 3) {
						
						aPantalla.mostrarPMensaje("Ha ingresado erróneamente el NIP. Cantidad de intentos: "
								+ cantidadIntentos + "\nAl tercer intento erróneo su cuenta será bloqueada."
								+ "\nPor favor, ingrese nuevamente su NIP.");
					} else {
						// Bloqueamos la cuenta y volvemos a la pantalla de Login.
						
						aBaseDeDatos.get(aIndexUsuarioLogeado).getUCuenta().setCBloqueada(true);
						aPantalla.mostrarPMensaje("Ha ingresado erróneamente tres veces el NIP. "
												+ "\nSu Cuenta ha sido bloqueada, por favor, "
												+ "diríjase a una Sucursal para regularizar su situación.\n");
						logear();						
					}					
				}									
				
			} else {
				// El NIP ingresado tiene cinco dígitos. Validamos que coincida con el NIP de la Cuenta.
				
				aPantalla.mostrarPMensaje("El NIP debe tener cinco dígitos."
						+ "\nPor favor, ingrese nuevamente su NIP.");			
			}
		}		
	}
	
	public boolean validarFondos(int origen, int comparable) {
		
		boolean fondosAtmOk = false;
		
		// Validamos que el importe a retirar no sea mayor a los fondos disponibles en el Dispensador del ATM.
		if (origen >= comparable) {
			fondosAtmOk = true;
		}
		return fondosAtmOk;
	}		
	
	public Pantalla getAPantalla() {
		return aPantalla;
	}

	public void setAPantalla(Pantalla aPantalla) {
		this.aPantalla = aPantalla;
	}

	public Teclado getATeclado() {
		return aTeclado;
	}

	public void setATeclado(Teclado aTeclado) {
		this.aTeclado = aTeclado;
	}

	public Dispensador getADispensador() {
		return aDispensador;
	}

	public void setADispensador(Dispensador aDispensador) {
		this.aDispensador = aDispensador;
	}

	public Ranura getARanura() {
		return aRanura;
	}

	public void setARanura(Ranura aRanura) {
		this.aRanura = aRanura;
	}
	
	public int getAIndexUsuarioLogeado() {
		return aIndexUsuarioLogeado;
	}

	public void setAIndexUsuarioLogeado(int aIndexUsuarioLogeado) {
		this.aIndexUsuarioLogeado = aIndexUsuarioLogeado;
	}
	
	public ArrayList<Usuario> getABaseDeDatos() {
		return aBaseDeDatos;
	}	

	public void setABaseDeDatos(ArrayList<Usuario> aBaseDeDatos) {
		this.aBaseDeDatos = aBaseDeDatos;
	}
	
	public ArrayList<Transaccion> getALogTransaccion() {
		return aLogTransaccion;
	}	

	public void setALogTransaccion(ArrayList<Transaccion> aLogTransaccion) {
		this.aLogTransaccion = aLogTransaccion;
	}

}
