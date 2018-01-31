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

@Entity
@Table(name="werknemers")
public class Werknemer implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	private String familienaam;
	private String voornaam;
	private String email;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "chefid")
	private Werknemer chef;
	//@Transient
	@OneToMany(mappedBy = "chef")
	private Set<Werknemer> ondergeschikten;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "jobtitelid")
	private Jobtitel jobtitel;
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
	
	public Set<Werknemer> getOndergeschikten() {
		return Collections.unmodifiableSet(ondergeschikten);
	}
	
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
