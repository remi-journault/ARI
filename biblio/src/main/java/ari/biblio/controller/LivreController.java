/**
 * 
 */
package ari.biblio.controller;

import java.util.List;

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
import ari.biblio.repository.LivreRepository;
import lombok.AllArgsConstructor;

/**
 * @author remij
 *
 */
@Controller
@AllArgsConstructor
public class LivreController {
	
	@Autowired
	private LivreRepository lr;
	
	@Autowired
	private AuteurRepository ar;
	
	@Autowired
	private BibliothequeRepository br;
	@CrossOrigin
	@PostMapping("/creerLivre")
	public String creerLivre(@RequestParam String titre, @RequestParam String nomAuteur) {
		List<Auteur> auteur = this.ar.findByNom(nomAuteur);
		Livre livre = new Livre(titre, br.findById(1), auteur);
		this.lr.save(livre);
		return "redirect:/recupererLivres";
	}
	
	@CrossOrigin
	@GetMapping("/recupererLivres")	
    public String recupererLivres(Model m) {
        m.addAttribute("livres", this.lr.findAll());
        return "livre";
    }
    
    @PostMapping("/majLivre/{id}")
    public String majLivre(@PathVariable("id") String id, @RequestParam String titre) {
        Livre livre = this.lr.findById(Integer.parseInt(id));
        livre.setTitre(titre);
        this.lr.save(livre);
    	return "redirect:/recupererLivres";
    }
    
    @PostMapping("/supprimerLivre/{id}")
    public String supprimerLivre(@PathVariable("id") String id){
        this.lr.deleteById(Integer.parseInt(id));
        return "redirect:/recupererLivres";
    }

}
