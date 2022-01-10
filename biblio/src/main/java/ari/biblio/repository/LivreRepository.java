/**
 * 
 */
package ari.biblio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ari.biblio.model.Livre;

/**
 * @author remij
 *
 */
public interface LivreRepository extends JpaRepository<Livre, Integer>{

	List<Livre> findByTitre(String titre);
	Livre findById(int id);

}
