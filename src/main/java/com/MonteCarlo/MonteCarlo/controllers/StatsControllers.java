package com.MonteCarlo.MonteCarlo.controllers;

import com.MonteCarlo.MonteCarlo.loginModels.User;
import com.MonteCarlo.MonteCarlo.services.VariableService;
import com.MonteCarlo.MonteCarlo.statsModels.Equation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.MonteCarlo.MonteCarlo.statsModels.Variable;

import java.util.Optional;

//To specify this is a controller (URls)
@RestController
public class StatsControllers {

    @Autowired
    VariableService variableService;

    @RequestMapping(value="Stats/variable")
    @PostMapping()
    public Variable addVariable(@RequestBody Variable variable){
        return variableService.addVariable(variable);

    }


    @GetMapping(path="Stats/getvariable/{id}")
    public Optional<Variable> getVariableByID (@PathVariable("id") Integer id){
        return this.variableService.getById(id);
    }


    //Here the URL of this controller is specified
    @RequestMapping(value="Stats")
    public double normalGenerator(){
        Variable variable = new Variable("variable", "normal", 1.5, 1.5);
        double value= variable.setRandomNormalValue ();
        return value;

    }

    @RequestMapping(value="Stats/Sal")
    public double rwa_salGeneratorl(){
        int i = 0;
        double salValue;

        //Try to get the last entry in case the user updates the data
        Variable phi = variableService.getByName("phi").get(variableService.getByName("phi").size()-1);
        Variable rt = variableService.getByName("rt").get(variableService.getByName("rt").size()-1);
        Variable m = variableService.getByName("m").get(variableService.getByName("m").size()-1);
        Equation rwa_sal = new Equation("Rw_Salinity");
        rwa_sal.addVariables(phi);
        rwa_sal.addVariables(rt);
        rwa_sal.addVariables(m);

        do {

            System.out.println(i);
            salValue = rwa_sal.combiner(rwa_sal.getVariables());
            System.out.println(salValue);
            i++;


        }
        while (i<10000);
        System.out.println("_______________");
        //return salValue;
        return rwa_sal.averager(rwa_sal.getMonteCarloIterations());

    }














    /*
    //Functional
    @RequestMapping(value="Stats/Sal")
    public double rwa_salGenerator(){
        int i = 0;
        double salValue;
        Variable phi = new Variable("phi", "normal", 0.335, 0.03701);
        Variable rt = new Variable("rt", "normal", 0.43245, 0.12971);
        Variable m = new Variable("m", "normal", 1.8, 0.2);
        Equation rwa_sal = new Equation("Rw_Salinity");
        rwa_sal.addVariables(phi);
        rwa_sal.addVariables(rt);
        rwa_sal.addVariables(m);

        do {

            System.out.println(i);
            salValue = rwa_sal.combiner(rwa_sal.getVariables());
            System.out.println(salValue);
            i++;


        }
        while (i<10000);
        System.out.println("_______________");
        //return salValue;
        return rwa_sal.averager(rwa_sal.getMonteCarloIterations());

        }

     */
    }

