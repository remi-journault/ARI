/**
 * 
 */
package ari.biblio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ari.biblio.model.Bd;

/**
 * @author remij
 *
 */
public interface BdRepository extends JpaRepository<Bd, Integer>{

	List<Bd> findByTitre(String titre);
	Bd findById(int id);

}
