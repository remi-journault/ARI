/**
 * 
 */
package ari.biblio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ari.biblio.model.Bibliotheque;

/**
 * @author remij
 *
 */
public interface BibliothequeRepository extends JpaRepository<Bibliotheque, Integer>{

	List<Bibliotheque> findByNom(String nom);
	Bibliotheque findById(int id);

}
