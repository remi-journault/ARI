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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author remij
 *
 */
@Entity
@RequiredArgsConstructor
public class Auteur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull private String prenom;
	@NonNull private String nom;

	@ManyToOne
	private Bibliotheque bibliotheque;

	@ManyToMany
	private List<Livre> livres = new ArrayList<Livre>();

	public Auteur() {}

	public Auteur(@NonNull String prenom, @NonNull String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}

	public Auteur(@NonNull String prenom, @NonNull String nom, Bibliotheque bibliotheque, List<Livre> livres) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.bibliotheque = bibliotheque;
		this.livres = livres;
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	 * @return the bibliotheque
	 */
	public Bibliotheque getBibliotheque() {
		return bibliotheque;
	}

	/**
	 * @param bibliotheque the bibliotheque to set
	 */
	public void setBibliotheque(Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}

	/**
	 * @return the livres
	 */
	public List<Livre> getLivres() {
		return livres;
	}

	/**
	 * @param livres the livres to set
	 */
	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

}
