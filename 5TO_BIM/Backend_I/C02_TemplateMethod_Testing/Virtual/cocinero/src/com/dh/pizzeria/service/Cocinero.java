package com.dh.pizzeria.service;

public abstract class Cocinero {

    public void hacerPizza(){
        prepararmasa();
        preCocinarMasa();
        prepararIngredientes();
        agregarIngredientes();
        cocinarPizza();
        empaquetarPizza();
    }

    // Primitive Operations/Methods
    protected abstract void prepararIngredientes();
    protected abstract void  agregarIngredientes();
    // Template Methods
    private void prepararmasa(){
        System.out.println("Preparando masa..");
    }
    private void preCocinarMasa(){
        System.out.println("Pre cocinando masa..");
    }
    private void cocinarPizza(){
        System.out.println("Enviando al horno la pizza");
    }
    private void empaquetarPizza(){
        System.out.println("Empaquetando pizza");
    }
}