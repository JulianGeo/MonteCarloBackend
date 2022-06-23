package com.MonteCarlo.MonteCarlo.statsModels;

import java.util.ArrayList;


public class Equation {
    private ArrayList<Variable> variables = new ArrayList<>();
    private String name;
    private ArrayList<Double> monteCarloIterations= new ArrayList<>();
    private double value;

    public Equation(String name) {
        this.name = name;
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public ArrayList<Double> getMonteCarloIterations() {
        return monteCarloIterations;
    }

    public void addVariables(Variable variable) {
        variables.add(variable);
    }

    public void addValues (Double monteCarloIteration){
        monteCarloIterations.add(monteCarloIteration);
    }

    //Returns average of monteCarlo results
    public double averager(ArrayList<Double> monteCarloIterations){


        return monteCarloIterations.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);





    }

    public double combiner(ArrayList<Variable> variables){

        switch(name){
            case "Rw_Salinity":
                // take this equation out this class
                double phi = variables.get(0).setRandomNormalValue();
                //System.out.println(phi);
                double log_rt = variables.get(1).setRandomNormalValue();
                System.out.println("log_rt: "+log_rt);
                double rt = Math.pow(10,log_rt);
                System.out.println("rt: "+rt);
                double m = variables.get(2).setRandomNormalValue();
                //System.out.println(m);
                int Tf = 100;
                double rwa = ((Math.pow(phi,m))*rt);
                System.out.println("rwa: "+rwa);
                double rwa_75 = rwa*((Tf+7)/82.0);
                double aFactor= ((3.562-Math.log10(rwa_75-0.0123))/0.955);
                value = Math.pow(10,aFactor);
                addValues(value);

        }
        return value;
    }
}


