package com.spring.esAPI.business;


import com.spring.esAPI.beans.TechniqueBean;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.esAPI.dao.TechniqueDao;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class GetTechniques {
    @Autowired
    TechniqueDao techniqueDao;
    public List<TechniqueBean> findTechniqueName(String techniqueName){

        return techniqueDao.findTechniqueName(techniqueName);
    }

    public List<TechniqueBean> findTechniqueID(String techniqueID){

        return techniqueDao.findTechniqueID(techniqueID);
    }

    public List<TechniqueBean> findTechniqueTactic(String techniqueTactic){

        return techniqueDao.findTechniqueTactic(techniqueTactic);
    }

    public List<TechniqueBean> findTechniqueSubtechnique(String techniqueSubtechnique){

        return techniqueDao.findTechniqueSubtechnique(techniqueSubtechnique);
    }

    public List<TechniqueBean> findTechniqueSubtechniqueOf(String techniqueSubtechniqueOf){

        return techniqueDao.findTechniqueSubtechniqueOf(techniqueSubtechniqueOf);
    }

    public List<TechniqueBean> findTechniqueAll(String techniqueAll){

        return techniqueDao.findTechniqueAll(techniqueAll);
    }

}
