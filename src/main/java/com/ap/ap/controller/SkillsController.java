package com.ap.ap.controller;

import com.ap.ap.models.Experiencia;
import com.ap.ap.models.Skills;
import com.ap.ap.services.ExperienciaService;
import com.ap.ap.services.SkillsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillsController {
    private final SkillsService skillsService;

    public SkillsController(SkillsService skillsService) {

        this.skillsService = skillsService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Skills>> obtenerSkills() {
        List<Skills> skillses= skillsService.buscarSkills();
        return new ResponseEntity<>(skillses, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Skills> editarSkills(@RequestBody Skills skills) {
        Skills updateSkills=skillsService.editarSkills(skills);
        return new ResponseEntity<>(updateSkills, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Skills> crearSkills(@RequestBody Skills skills) {
        Skills nuevaSkills=skillsService.addSkills(skills);
        return new ResponseEntity<>(nuevaSkills,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarSkills(@PathVariable("id") Long id){
        skillsService.borrarSkills(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
