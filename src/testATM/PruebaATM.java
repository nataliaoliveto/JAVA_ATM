package testATM;

import java.util.ArrayList;
import miscellaneous.*;
import softwareATM.*;

public class PruebaATM {

	public static void main(String[] args) {
		
		Fecha f1 = new Fecha("5/5/2001");
		Fecha f2 = new Fecha("1/1/1998");
		Fecha f3 = new Fecha("20/3/1998");
		Fecha f4 = new Fecha("6/10/1994");
		Fecha f5 = new Fecha("31/12/1991");
		Fecha f6 = new Fecha("2/4/1974");
		Fecha f7 = new Fecha("15/7/2002");
		Fecha f8 = new Fecha("18/1/2002");
		Fecha f9 = new Fecha("7/12/1989");

		Direccion d  = new Direccion("Av. Córdoba", 4860, 1416, "CABA", "CABA");	
		Direccion d1 = new Direccion("Salguero", 2345, 1756, "CABA", "CABA");
		Direccion d2 = new Direccion("Av. Santa Fe", 3483, 'B', 12, 1312, "CABA", "CABA");
		Direccion d3 = new Direccion("Serrano", 1214, 1218, "CABA", "CABA");
		Direccion d4 = new Direccion("Av. Las Heras", 4320, 'A', 8, 1614, "CABA", "CABA");
		Direccion d5 = new Direccion("Av. Figueroa Alcorta", 5580, 'C', 7, 1268, "CABA", "CABA");
		Direccion d6 = new Direccion("Bulnes", 1767, 1614, "CABA", "CABA");
		Direccion d7 = new Direccion("Av. Del Libertador", 4365, 'A', 9, 1216, "CABA", "CABA");
		Direccion d8 = new Direccion("Ravignani", 1148, 1678, "CABA", "CABA");
		Direccion d9 = new Direccion("Uriarte", 1765, 1214, "CABA", "CABA");
		
		// Para testear: En el constructor está primero cuenta, segundo NIP
		// Es el mismo para facilitar la prueba!
		Cuenta c1 = new Cuenta(11111, 11111, "Caja de Ahorro", "Pesos", 150000D);
		Cuenta c2 = new Cuenta(22222, 22222, "Cuenta Corriente", "Pesos", 55000D);
		Cuenta c3 = new Cuenta(33333, 33333, "Cuenta Corriente", "Pesos", 60200D);
		Cuenta c4 = new Cuenta(44444, 44444, "Caja de Ahorro", "Pesos", 50000D);
		Cuenta c5 = new Cuenta(55555, 55555, "Caja de Ahorro", "Pesos", 120000D);
		Cuenta c6 = new Cuenta(66666, 66666, "Cuenta Corriente", "Pesos", 43800D);
		Cuenta c7 = new Cuenta(77777, 77777, "Caja de Ahorro", "Pesos", 100000D);
		Cuenta c8 = new Cuenta(88888, 88888, "Cuenta Corriente", "Pesos", 90000D);
		Cuenta c9 = new Cuenta(99999, 99999, "Caja de Ahorro", "Pesos", 110000D);
		
		Usuario u1 = new Usuario("Luffy D.", "Monkey", 33111333, f1, d1, c1);
		Usuario u2 = new Usuario("Ace D.", "Portgas", 33222333, f2, d2, c2);
		Usuario u3 = new Usuario("Sabo", "Saba", 33333333, f3, d3, c3);
		Usuario u4 = new Usuario("Law D.", "Trafalgar", 33444333, f4, d4, c4);
		Usuario u5 = new Usuario("Yamato", "Kaido", 33555333, f5, d5, c5);
		Usuario u6 = new Usuario("Jinbe", "Shark", 33666333, f6, d6, c6);
		Usuario u7 = new Usuario("Mirio", "Togata", 33777333, f7, d7, c7);
		Usuario u8 = new Usuario("Touya", "Todoroki", 33888333, f8, d8, c8);
		Usuario u9 = new Usuario("Gojo", "Satoru", 33999333, f9, d9, c9);
		
		ArrayList<Usuario> bBaseDeDatos = new ArrayList<Usuario>();
		bBaseDeDatos.add(u1);
		bBaseDeDatos.add(u2);
		bBaseDeDatos.add(u3);
		bBaseDeDatos.add(u4);
		bBaseDeDatos.add(u5);
		bBaseDeDatos.add(u6);
		bBaseDeDatos.add(u7);
		bBaseDeDatos.add(u8);
		bBaseDeDatos.add(u9);
		
		Banco banco = new Banco("Banco de Wano", "12-12345678-3", d, 47869876, bBaseDeDatos);
		Atm atm = new Atm(banco.getBBaseDeDatos());
		banco.setBAtm(atm);

		// Comienzo del sistema
		// Para testear: En el constructor está primero cuenta, segundo NIP
		// Es el mismo para facilitar la prueba!
		banco.getBAtm().logear();
		
		// Si quisiese verse, de ampliarse el sistema, la información del Banco, Usuario o Cuenta,
		// se pueden llamar desde System.out.println(nombreObjeto);
		// No se sobrescribió el toString del ATM ya que no es necesario para el sistema
		// según el scope del requerimiento y la funcionalidad requerida.
		
	}

}
