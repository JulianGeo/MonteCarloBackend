package com.MonteCarlo.MonteCarlo.statsModels;

import jdistlib.Normal;
import jdistlib.Uniform;
import jdistlib.rng.*;

public class Variable {
    //Variable name
    private String name;
    //Variable statistical distribution
    private String dist;
    //Variable mean
    private double mu;
    //Variable standard deviation
    private double sigma;
    //Variable random value
    private double value;
    // The only randomEngine that worked in the iterations was RandomWELL
    private RandomEngine random = new RandomWELL44497b();


    public Variable(String name, String dist, double mu, double sigma) {
        this.name = name;
        this.dist = dist;
        this.mu = mu;
        this.sigma = sigma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public double getMu() {
        return mu;
    }

    public void setMu(double mu) {
        this.mu = mu;
    }

    public double getSigma() {
        return sigma;
    }

    public void setSigma(double sigma) {
        this.sigma = sigma;
    }

    public double setRandomNormalValue (){
        switch (this.dist){

            case "Uniform":
                this.value= Uniform.random(1.5, 2.0, random);
                break;
            case "Normal":
                this.value=Normal.random(this.mu, this.sigma, random);
                break;
            default:
                this.value=Normal.random(this.mu, this.sigma, random);
                break;
        }
        return this.value;

    }

}
