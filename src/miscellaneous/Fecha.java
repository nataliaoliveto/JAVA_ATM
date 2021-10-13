package miscellaneous;

public class Fecha {
	
	private int fDia;
	private int fMes;
	private int fAnio;
	
	public Fecha (String s) {
		
		int pos1 = s.indexOf('/');
		int pos2 = s.lastIndexOf('/');
				
		String sDia = s.substring(0,pos1);
		fDia = Integer.parseInt(sDia);
		
		String sMes = s.substring(pos1+1,pos2);
		fMes = Integer.parseInt(sMes);
		
		String sAnio = s.substring(pos2+1);
		fAnio = Integer.parseInt(sAnio);
	
	}

	public Fecha(int fDia, int fMes, int fAnio) {
		setFDia(fDia);
		setFMes(fMes);
		setFAnio(fAnio);
	}
	
	private int fechaToDias() {
		return fAnio * 360 + fMes * 30 + fDia;
	}
	
	private void diasToFecha(int i) {
		
		fAnio = (int) i/360; 
		int resto = i%360;
		fMes = (int) resto/30;
		fDia = resto%30;
		
		if(fDia == 0) {
			fDia = 30;
			fMes--; 
		}
		
		if(fMes == 0) {
			fMes = 12;
			fAnio--;
		}	
	}
	
	public void addDias(int d) {	
		int sum = fechaToDias() + d;				
		diasToFecha(sum);
	}
	
	public int getFDia() {
		return fDia;
	}

	public void setFDia(int dDia) {
		this.fDia = dDia;
	}

	public int getFMes() {
		return fMes;
	}

	public void setFMes(int dMes) {
		this.fMes = dMes;
	}

	public int getFAnio() {
		return fAnio;
	}

	public void setFAnio(int dAnio) {
		this.fAnio = dAnio;
	}
	
	public String toString() {
		return getFDia() + "/" + getFMes() + "/" + getFAnio();
	}

}
