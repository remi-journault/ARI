/**
 * 
 */
package ari.biblio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ari.biblio.model.Roman;

/**
 * @author remij
 *
 */
public interface RomanRepository extends JpaRepository<Roman, Integer>{

	List<Roman> findByTitre(String titre);
	Roman findById(int id);

}
