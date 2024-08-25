package com.medrano.marino.demoHprpg2022.Spells;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hprpg/spells/")
public class SpellRESTController {
    private SpellService spellService;

    @Autowired
    public SpellRESTController(SpellService spellService) {
        this.spellService = spellService;
    }

    //Read
    @GetMapping(path = "types")
    public List<SpellType> getTypes() {
        return spellService.getSpellsTypes();
    }

    @GetMapping(path = "search/{words}")
    public List<Spells> getByWordsInDescription(@PathVariable("words") String words) {
        return spellService.getByWordInDescription(words);
    }
    //Create

    /**
     * {
     * "name": [NAME],
     * "description": [Description],
     * "is_visible": true,
     * "max_progression": 100,
     * "spell_type": "BOOKS"
     * }
     *
     * @param spell
     */
    @PostMapping(path = "add")
    public void createSpell(@RequestBody Spells spell) {
        System.out.println(spell.toString());
        if (spell.getName().isEmpty() || spell.getName().isBlank() || spell.getDescription().isBlank() || spell.getDescription().isEmpty()) {
            System.out.println("Empty name or description");
        } else {
            Boolean spellIsEmpty = this.spellService.getByName(spell.getName()).isEmpty();

            if (spellIsEmpty)
                spellService.createSpell(spell);
        }
    }

    //Update
    @PutMapping(path = "update")
    public void updateSpell(@RequestBody Spells spell) {
        System.out.println(spell.toString());
        if (spell.getName().isEmpty() || spell.getName().isBlank() || spell.getDescription().isBlank() || spell.getDescription().isEmpty()) {
            System.out.println("Empty name or description");
        } else {
            Spells spellFound = this.spellService.getById(spell.getId());
            Boolean spellIsNotEmpty = !spellFound.getName().isEmpty();
            System.out.println(spellIsNotEmpty);

            if (spellIsNotEmpty)
                spellService.updateSpell(spell);
        }
    }

    //Delete
    @DeleteMapping(path = "delete/{id}")
    public void deleteSpell(@PathVariable("id") int id, @RequestBody Spells spell) {
        if (id >= 0) {
            System.out.println("DELETE");
            System.out.println(spell.toString());

            Spells spellFound = this.spellService.getById(id);
            System.out.println(spellFound);

            Boolean spellsMatch = spell.equals(spellFound);
            System.out.println(spellsMatch);

            if (spellsMatch)
                this.spellService.deleteSpell(spell);
        }
    }
}
