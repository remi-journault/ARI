/**
 * 
 */
package ari.biblio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ari.biblio.model.Lecteur;
import ari.biblio.repository.BibliothequeRepository;
import ari.biblio.repository.LecteurRepository;
import lombok.AllArgsConstructor;

/**
 * @author remij
 *
 */
@Controller
@AllArgsConstructor
public class LecteurController {
	@Autowired
	private LecteurRepository lr;
	
	@Autowired
	private BibliothequeRepository br;
	
	@CrossOrigin
	@PostMapping("/creerLecteur")
	public String creerLecteur(@RequestParam String prenom, @RequestParam String nom) {
		Lecteur lecteur = new Lecteur(prenom, nom, br.findById(1));
		this.lr.save(lecteur);
		return "redirect:/recupererLecteurs";
	}
	
	@CrossOrigin
	@GetMapping("/recupererLecteurs")	
    public String recupererLecteurs(Model m) {
        m.addAttribute("lecteurs", this.lr.findAll());
        return "lecteur";
    }
    
    @PostMapping("/majLecteurs/{id}")
    public String majLecteurs(@PathVariable("id") String id, @RequestParam String prenom,@RequestParam String nom) {
        Lecteur lecteur = this.lr.findById(Integer.parseInt(id));
        lecteur.setPrenom(prenom);
        lecteur.setNom(nom);
        this.lr.save(lecteur);
    	return "redirect:/recupererLecteurs";
    }
    
    @PostMapping("/supprimerLecteur/{id}")
    public String supprimerLecteur(@PathVariable("id") String id){
        this.lr.deleteById(Integer.parseInt(id));
        return "redirect:/recupererLecteurs";
    }

}
