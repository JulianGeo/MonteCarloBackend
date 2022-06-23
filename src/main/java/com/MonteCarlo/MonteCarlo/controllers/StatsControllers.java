package com.MonteCarlo.MonteCarlo.controllers;

import com.MonteCarlo.MonteCarlo.statsModels.Equation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.MonteCarlo.MonteCarlo.statsModels.Variable;

//To specify this is a controller (URls)
@RestController
public class StatsControllers {
    //Here the URL of this controller is specified
    @RequestMapping(value="stats")
    public double normalGenerator(){
        Variable variable = new Variable("variable", "normal", 1.5, 1.5);
        double value= variable.setRandomNormalValue ();
        return value;

    }

    @RequestMapping(value="sal")
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
    }

