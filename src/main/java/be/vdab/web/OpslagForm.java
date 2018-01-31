package be.vdab.web;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

class OpslagForm {
	@NotNull
	@DecimalMin("1")
	private BigDecimal opslag;

	protected BigDecimal getOpslag() {
		return opslag;
	}

	protected void setOpslag(BigDecimal opslag) {
		this.opslag = opslag;
	}
}
