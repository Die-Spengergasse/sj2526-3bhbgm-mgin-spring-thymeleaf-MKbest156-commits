package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.FahrzeugRepository;
import at.spengergasse.spring_thymeleaf.entities.Fahrzeuge;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fahrzeuge")
public class FahrzeugController {

    private final FahrzeugRepository fahrzeugRepository;


    // Konstruktor
    public FahrzeugController(FahrzeugRepository fahrzeugRepository) {
        this.fahrzeugRepository = fahrzeugRepository;
    }

    // ALLE Fahrzeuge anzeigen
    @GetMapping("/list")
    public String fahrzeuge(Model model) {
        model.addAttribute("fahrzeuge", fahrzeugRepository.findAll());
        return "fahrzeugelist";
    }

    // Neues Fahrzeug hinzufügen  (muss man noch updaten)
    @GetMapping("/add")
    public String addFahrzeugForm(Model model) {
        model.addAttribute("fahrzeug", new Fahrzeuge());
        return "add_fahrzeug";
    }

    // Neues Fahrzeug speichern
    @PostMapping("/add")
    public String addFahrzeug(@ModelAttribute("fahrzeug") Fahrzeuge fahrzeug) {
        fahrzeugRepository.save(fahrzeug);
        return "redirect:/fahrzeuge/list";
    }

    // Fahrzeug löschen
    @GetMapping("/delete/{id}")
    public String deleteFahrzeug(@PathVariable("id") int id) {
        fahrzeugRepository.deleteById(id);
        return "redirect:/fahrzeuge/list";
    }

    // Fahrzeug bearbeiten - (muss man noch updaten)
    @GetMapping("/edit/{id}")
    public String editFahrzeugForm(@PathVariable("id") int id, Model model) {
        Fahrzeuge fahrzeug = fahrzeugRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ungültige ID: " + id));

        model.addAttribute("fahrzeug", fahrzeug);
        return "edit_fahrzeug";
    }

    // Fahrzeug aktualisieren
    @PostMapping("/update/{id}")
    public String updateFahrzeug(@PathVariable("id") int id,
                                 @ModelAttribute("fahrzeug") Fahrzeuge fahrzeug) {

        fahrzeug.setId(id);
        fahrzeugRepository.save(fahrzeug);

        return "redirect:/fahrzeuge/list";
    }
}
