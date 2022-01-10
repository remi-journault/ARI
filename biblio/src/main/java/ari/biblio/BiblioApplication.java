package ari.biblio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ari.biblio.model.Auteur;
import ari.biblio.model.Bibliotheque;
import ari.biblio.model.Lecteur;
import ari.biblio.repository.AuteurRepository;
import ari.biblio.repository.BibliothequeRepository;
import ari.biblio.repository.LecteurRepository;
import ari.biblio.repository.LivreRepository;

@SpringBootApplication
public class BiblioApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiblioApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(AuteurRepository auteurRepository, LivreRepository livreRepository, BibliothequeRepository bibliothequeRepository, LecteurRepository lecteurRepository) {
		return args -> {
			Bibliotheque bibliotheque = new Bibliotheque("Bibliotheque");
			bibliotheque = bibliothequeRepository.save(bibliotheque);
			Bibliotheque bibliobus = new Bibliotheque("Bibliobus");
			bibliobus = bibliothequeRepository.save(bibliobus);

			Auteur auteur = new Auteur("J.R.R", "Tolkien");
			auteur = auteurRepository.save(auteur);

			Lecteur lecteur = new Lecteur("Remi", "Journault");
			lecteur = lecteurRepository.save(lecteur);
		};
	}

}
