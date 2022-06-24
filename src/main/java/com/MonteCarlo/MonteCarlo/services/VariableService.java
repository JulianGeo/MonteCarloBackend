package com.MonteCarlo.MonteCarlo.services;

import com.MonteCarlo.MonteCarlo.loginModels.User;
import com.MonteCarlo.MonteCarlo.repositories.VariableRepository;
import com.MonteCarlo.MonteCarlo.statsModels.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class VariableService {
    @Autowired
    VariableRepository variableRepository;

    public ArrayList<Variable> getVariable(){
        return (ArrayList<Variable>)variableRepository.findAll();
    }

    public Variable addVariable(Variable variable){
        return variableRepository.save(variable);
    }

    public Optional<Variable> getById(Integer id){
        return variableRepository.findById(id);
    }

    public ArrayList<Variable> getByName(String name){
        return variableRepository.findByName(name);
    }

    // TryCatch in case ID doesn't exist
    public boolean deleteVariable(Integer id){
        try{
            variableRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
