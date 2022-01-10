/**
 * 
 */
package ari.biblio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ari.biblio.model.Auteur;

/**
 * @author remij
 *
 */
public interface AuteurRepository extends JpaRepository<Auteur, Integer>{

	List<Auteur> findByNom(String nom);
	Auteur findById(int id);

}
