package com.visorNetCDF.persistencia;

/**
 * Clase para persistencia
 */
public class VariableDTO {

	private String nombre;
	private String tipoDato;
	private String descripcion;
	private String dimensiones;
	private String forma;
	private String unidades;
	private String valores;
	private String atributos;
	private String grupo;

	public VariableDTO() {
	}

	public VariableDTO(String nombre, String tipoDato, String descripcion, String dimensiones, String forma,
			String unidades) {
		this.nombre = nombre;
		this.tipoDato = tipoDato;
		this.descripcion = descripcion;
		this.dimensiones = dimensiones;
		this.forma = forma;
		this.unidades = unidades;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public String getUnidades() {
		return unidades;
	}

	public void setUnidades(String unidades) {
		this.unidades = unidades;
	}

	public String getValores() {
		return valores;
	}

	public void setValores(String valores) {
		this.valores = valores;
	}

	public String getAtributos() {
		return atributos;
	}

	public void setAtributos(String atributos) {
		this.atributos = atributos;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

}
