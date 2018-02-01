package be.vdab.web;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import be.vdab.constraints.Opslag;

class OpslagForm {
	@NotNull
	@Opslag
	private BigDecimal opslag;
	private int versie;

	protected BigDecimal getOpslag() {
		return opslag;
	}

	protected int getVersie() {
		return versie;
	}
}
