/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teclado_prop;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aitor
 */
public class LanzarThread  extends Thread implements Runnable {
    private int[] solucio_trobada;
    private boolean hi_ha;
    private double[][] matriu_distancies;
    private double[][] matriu_similituds;
    private Solucio solucio;
    private int altura_minima_gilmore;
    private long tiempoIniciocs;
    private int[] solucio_inicial;
    private long tiempotranscurrido;
    
    
    public LanzarThread(double[][] matriu_distancies, double[][] matriu_similituds,int[] solucio_incial, Solucio solucio,int altura_minima_gilmore) {
        this.hi_ha = false;
        this.matriu_distancies =  matriu_distancies;
        this.matriu_similituds = matriu_similituds;
        this.solucio_inicial = solucio_incial;
        this.solucio = solucio;
        this.altura_minima_gilmore = altura_minima_gilmore;
        this.start();
    }
    
    public void set_temps_inicial(long temps_incial){
        this.tiempoIniciocs = temps_incial;
    }
    
    public void run(){
       Algoritmo algoritmo = new Algoritmo();
       long tiempoInicio = System.currentTimeMillis(); 
       this.set_temps_inicial(tiempoInicio);
       solucio_trobada = algoritmo.calcular(matriu_distancies, matriu_similituds, solucio_inicial,altura_minima_gilmore);
       long totalTiempo = System.currentTimeMillis() - tiempoInicio;
       imprimir_temps_execucio(totalTiempo,0);
       hi_ha = true;
       solucio.calcul_realitzat(totalTiempo);
        
    }
   
    public void imprimir_temps_execucio_actual(){
        long tiempofinal = System.currentTimeMillis(); 
        imprimir_temps_execucio(tiempofinal-this.tiempoIniciocs,2);
    }
    
    public void parar(){
        long tiempofinal = System.currentTimeMillis(); 
        this.stop();
        this.hi_ha = false;
        imprimir_temps_execucio(tiempofinal-this.tiempoIniciocs,1);
    }
    
    public void imprimir_temps_execucio(long temps,int proces){
        long minuts = 0;
        long segons = 0;
        long milesimas = temps;
        if(temps >= 1000){
            segons = temps/1000;
            milesimas = temps%1000;
            if(segons >= 60){
                minuts = segons/60;
                segons = segons%60;
            }
        }
        this.tiempotranscurrido = temps;
        //if(proces == 0)System.out.println("El calculo realizado (minuts:segons:milesimes):\t" + minuts +":"+segons+":"+milesimas); 
        //else if(proces == 1)System.out.println("Interrumpuda!, portaba executan-se (minuts:segons:milesimes):\t\t\t" + minuts +":"+segons+":"+milesimas);
        //else if(proces == 2)System.out.println("\t\tPorta el seguent temps executant (minuts:segons:milesimes):\t\t\t" + minuts +":"+segons+":"+milesimas);
    }
   
    public boolean hi_ha_solucio() {
        return hi_ha;
    }
    
    public int[] get_solucio() {
        return solucio_trobada;
    }
    
}
