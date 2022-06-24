package com.MonteCarlo.MonteCarlo.repositories;

import com.MonteCarlo.MonteCarlo.statsModels.Variable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface VariableRepository extends CrudRepository<Variable, Integer> {
    public abstract ArrayList<Variable> findByName(String name);
}
