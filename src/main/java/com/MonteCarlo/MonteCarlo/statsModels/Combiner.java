package com.MonteCarlo.MonteCarlo.statsModels;

import java.util.ArrayList;

public class Combiner {
    private ArrayList<Variable> variables = new ArrayList<>();
    private ArrayList<String> equations = new ArrayList<>();
    private String equation;


    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void addVariables(Variable variable) {
        variables.add(variable);
    }

    public ArrayList<String> getEquations() {
        return equations;
    }

    public void addEquations(String equation) {
        equations.add(equation);
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        if (equations.contains(equation)){
            this.equation = equation;
        } else {
            System.out.println("The equation is not available yet");
        }

    }




}
