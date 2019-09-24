package com.Alejo.ws.rest.vo;

public class UsuarioVo {
	
	private String usuario;
	private String pass;
	private boolean validacion;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean isValidacion() {
		return validacion;
	}
	public void setValidacion(boolean validacion) {
		this.validacion = validacion;
	}

}
