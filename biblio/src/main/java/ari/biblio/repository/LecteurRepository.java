/**
 * 
 */
package ari.biblio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ari.biblio.model.Lecteur;

/**
 * @author remij
 *
 */
public interface LecteurRepository extends JpaRepository<Lecteur, Integer>{

	List<Lecteur> findByNom(String nom);
	Lecteur findById(int id);

}
