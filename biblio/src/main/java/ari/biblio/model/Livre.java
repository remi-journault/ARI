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
public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull private String titre;

	@ManyToOne
	private Bibliotheque bibliotheque;

	@ManyToMany
	private List<Auteur> auteurs = new ArrayList<Auteur>();


	public Livre() {}


	public Livre( @NonNull String titre, List<Auteur> auteurs) {
		super();
		this.titre = titre;
		this.auteurs = auteurs;
	}


	public Livre(@NonNull String titre, Bibliotheque bibliotheque, List<Auteur> auteurs) {
		super();
		this.titre = titre;
		this.bibliotheque = bibliotheque;
		this.auteurs = auteurs;
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
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}


	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
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
	 * @return the auteurs
	 */
	public List<Auteur> getAuteurs() {
		return auteurs;
	}


	/**
	 * @param auteurs the auteurs to set
	 */
	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

}
