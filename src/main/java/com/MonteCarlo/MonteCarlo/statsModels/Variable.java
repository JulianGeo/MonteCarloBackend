package com.MonteCarlo.MonteCarlo.statsModels;

import jdistlib.Normal;
import jdistlib.Uniform;
import jdistlib.rng.*;

import javax.persistence.*;

@Entity
@Table(name="variable")
public class Variable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
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


    public Variable() {
    }

    // The only randomEngine that worked in the iterations was RandomWELL
    public RandomEngine randomEngineCreator (){
        RandomEngine random = new RandomWELL44497b();
        return random;
    }

    public Variable(String name, String dist, double mu, double sigma) {
        this.name = name;
        this.dist = dist;
        this.mu = mu;
        this.sigma = sigma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
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
                this.value= Uniform.random(1.5, 2.0, randomEngineCreator());
                break;
            case "Normal":
                this.value=Normal.random(this.mu, this.sigma, randomEngineCreator());
                break;
            default:
                this.value=Normal.random(this.mu, this.sigma, randomEngineCreator());
                break;
        }
        return this.value;

    }

}
