/**
 * 
 */
package ari.biblio.model;

import javax.persistence.Entity;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author remij
 *
 */
@Entity
@RequiredArgsConstructor
public class Bd extends Livre{

	@NonNull private String serie;

	public Bd() {}

	public Bd(@NonNull String serie) {
		super();
		this.serie = serie;
	}

	/**
	 * @return the serie
	 */
	public String getSerie() {
		return serie;
	}

	/**
	 * @param serie the serie to set
	 */
	public void setSerie(String serie) {
		this.serie = serie;
	}

}
