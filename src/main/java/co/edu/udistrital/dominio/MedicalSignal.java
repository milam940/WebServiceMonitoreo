package co.edu.udistrital.dominio;

import java.io.Serializable;

public class MedicalSignal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5158929344376868187L;
	private String idDispositivo;
	private String tipoDato;
	private String dato;
	private String idPaciente;
	
	
	public String getIdDispositivo() {
		return idDispositivo;
	}
	public void setIdDispositivo(String idDispositivo) {
		this.idDispositivo = idDispositivo;
	}
	public String getTipoDato() {
		return tipoDato;
	}
	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}
	public String getDato() {
		return dato;
	}
	public void setDato(String dato) {
		this.dato = dato;
	}
	public String getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}
	
}
