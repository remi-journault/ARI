/**
 * 
 */
package ari.biblio.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ari.biblio.model.Auteur;
import ari.biblio.model.Livre;
import ari.biblio.repository.AuteurRepository;
import ari.biblio.repository.BibliothequeRepository;
import lombok.AllArgsConstructor;

/**
 * @author remij
 *
 */
@Controller
@AllArgsConstructor
public class AuteurController {

	@Autowired
	private AuteurRepository ar;

	@Autowired
	private BibliothequeRepository br;

	@CrossOrigin
	@PostMapping("/creerAuteur")
	public String creerAuteur(@RequestParam String prenom, @RequestParam String nom) {
		Auteur auteur = new Auteur(prenom, nom, br.findById(1), new ArrayList<Livre>());
		this.ar.save(auteur);
		return "redirect:/recupererAuteurs";
	}

	@CrossOrigin
	@GetMapping("/recupererAuteurs")	
	public String recupererAuteurs(Model m) {
		m.addAttribute("authors", this.ar.findAll());
		return "auteur";
	}

	@PostMapping("/majAuteur/{id}")
	public String majAuteur(@PathVariable("id") String id, @RequestParam String prenom,@RequestParam String nom) {
		Auteur auteur = this.ar.findById(Integer.parseInt(id));
		auteur.setPrenom(prenom);
		auteur.setNom(nom);
		this.ar.save(auteur);
		return "redirect:/recupererAuteurs";
	}

	@PostMapping("/supprimerAuteur/{id}")
	public String supprimerAuteur(@PathVariable("id") String id){
		this.ar.deleteById(Integer.parseInt(id));
		return "redirect:/recupererAuteurs";
	}

}
