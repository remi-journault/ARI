/**
 * 
 */
package ari.biblio.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author remij
 *
 */
@RequiredArgsConstructor
@Entity
public class Bibliotheque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull private String nom;

	@OneToMany()
	private final List<Auteur> auteurs = new ArrayList<Auteur>();

	@OneToMany()
	private final List<Lecteur> lecteurs = new ArrayList<Lecteur>();

	@OneToMany()
	private final List<Livre> livres = new ArrayList<Livre>();

	public Bibliotheque() {	}

	public Bibliotheque(@NonNull String nom) {
		super();
		this.nom = nom;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the auteurs
	 */
	public List<Auteur> getAuteurs() {
		return auteurs;
	}

	/**
	 * @return the lecteurs
	 */
	public List<Lecteur> getLecteurs() {
		return lecteurs;
	}

	/**
	 * @return the livres
	 */
	public List<Livre> getLivres() {
		return livres;
	}

}
