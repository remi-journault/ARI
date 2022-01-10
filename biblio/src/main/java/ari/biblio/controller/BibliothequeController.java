/**
 * 
 */
package ari.biblio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ari.biblio.model.Bibliotheque;
import ari.biblio.repository.BibliothequeRepository;
import lombok.AllArgsConstructor;

/**
 * @author remij
 *
 */
@Controller
@AllArgsConstructor
public class BibliothequeController {
	
	@Autowired
	private BibliothequeRepository br;

	@ModelAttribute("biblio")
	public Bibliotheque biblio() {
		return new Bibliotheque();
	}

	@CrossOrigin
	@PostMapping("/creerBibliotheque")
	public String creerBibliotheque(@RequestParam String nom) {
		Bibliotheque bibliotheque = new Bibliotheque(nom);
		this.br.save(bibliotheque);
		return "redirect:/";
	}

	@CrossOrigin
	@GetMapping("/")	
	public String recupererBibliotheque(Model m) {
		m.addAttribute("bibliotheques", this.br.findAll());
		return "home";
	}	

}
