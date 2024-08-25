package com.medrano.marino.demoHprpg2022.Spellbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/hprpg/spellbook/")
public class SpellBookRESTController {
    private SpellBookService spellBookService;

    @Autowired
    public SpellBookRESTController(SpellBookService spellBookService) {
        this.spellBookService = spellBookService;
    }

    @GetMapping
    public List<ISpellbookSimple> getAll(){
        return spellBookService.getAll();
    }

    @GetMapping(path = "qty/{id}")
    public ICharacterSpellbookCount getSpellbookCount(@PathVariable("id") int id){
        return spellBookService.getSpellbookCount(id);
    }
}
