package com.spring.esAPI.controller;


import com.spring.esAPI.beans.TechniqueBean;
import com.spring.esAPI.business.GetTechniques;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping

public class TechniqueController {

    @Autowired
    GetTechniques getTechniques;

    @GetMapping("/techName/{techName}")
    public List<TechniqueBean> findTechniqueName(@PathVariable String techName){
        return getTechniques.findTechniqueName(techName);
    }
    @GetMapping("/techID/{techID}")
    public List<TechniqueBean> findTechniqueID(@PathVariable String techID){
        return getTechniques.findTechniqueID(techID);
    }

    @GetMapping("/techTactic/{techTactic}")
    public List<TechniqueBean> findTechniqueTactic(@PathVariable String techTactic){
        return getTechniques.findTechniqueTactic(techTactic);
    }

    @GetMapping("/techSubtechnique/{techSubtechnique}")
    public List<TechniqueBean> findTechniqueSubtechnique(@PathVariable String techSubtechnique){
        return getTechniques.findTechniqueSubtechnique(techSubtechnique);
    }

    @GetMapping("/techSubtechniqueOf/{techSubtechniqueOf}")
    public List<TechniqueBean> findTechniqueSubtechniqueOf(@PathVariable String techSubtechniqueOf){
        return getTechniques.findTechniqueSubtechniqueOf(techSubtechniqueOf);
    }

    @GetMapping("/techAll/{techAll}")
    public List<TechniqueBean>findTechniqueAll(@PathVariable String techAll){
        return getTechniques.findTechniqueAll(techAll);
    }
}
