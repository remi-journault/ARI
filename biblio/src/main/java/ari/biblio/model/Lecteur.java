/**
 * 
 */
package ari.biblio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author remij
 *
 */
@Entity
@RequiredArgsConstructor
public class Lecteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private String prenom;
    @NonNull private String nom;
    
    @ManyToOne
    private Bibliotheque bibliotheque;
    
    public Lecteur() {}

	public Lecteur(@NonNull String prenom, @NonNull String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}

	public Lecteur(@NonNull String prenom, @NonNull String nom, Bibliotheque bibliotheque) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.bibliotheque = bibliotheque;
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

}
