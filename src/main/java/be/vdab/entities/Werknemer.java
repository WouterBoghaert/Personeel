package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="werknemers")
public class Werknemer implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	@NotBlank
	@Length(min=1, max = 50)
	private String familienaam;
	@NotBlank
	@Length(min=1, max = 50)
	private String voornaam;
	@Email
	@NotBlank
	@Length(min=1, max = 100)
	private String email;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "chefid")
	@Valid
	private Werknemer chef;
	//@Transient
	/*@OneToMany(mappedBy = "chef")
	@Valid
	private Set<Werknemer> ondergeschikten;*/
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "jobtitelid")
	@NotNull
	@Valid
	private Jobtitel jobtitel;
	@NumberFormat(pattern = "#,##0")
	@NotNull
	@Digits(integer=10,fraction=2)
	@DecimalMin("0") //misschien nog eigen annotation van maken!!!
	private BigDecimal salaris;
	private int versie;
	
	public long getId() {
		return id;
	}
	
	public String getFamilienaam() {
		return familienaam;
	}
	
	public String getVoornaam() {
		return voornaam;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Werknemer getChef() {
		return chef;
	}
	
	/*public Set<Werknemer> getOndergeschikten() {
		return Collections.unmodifiableSet(ondergeschikten);
	}*/
	
	public Jobtitel getJobtitel() {
		return jobtitel;
	}
	
	public BigDecimal getSalaris() {
		return salaris;
	}
	
	public int getVersie() {
		return versie;
	}
	
	public void geefOpslag(BigDecimal bedrag) {
		salaris = salaris.add(bedrag);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Werknemer)) {
			return false;
		}
		Werknemer other = (Werknemer) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		return true;
	}
}
