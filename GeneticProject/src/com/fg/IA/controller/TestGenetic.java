package com.fg.IA.controller;

import com.fg.IA.model.Chromosome;

/**
 * Genetic Algorithm Java classes
 *
 * <p/>
 * Copyright 1996-2012 by Mark Watson. All rights reserved.
 * <p/>
 * This software is can be used under either of the following licenses:
 * <p/>
 * 1. LGPL v3<br/>
 * 2. Apache 2
 * <p/>
 */
public class TestGenetic {	
	
   public static MyGenetic genetic_experiment;

   Chromosome chromosome = new Chromosome();
   
    public static void main(String args[]) {    	
    
        // we will use chromosomes with 10 1 bit genes per
        // chromosomes, and a population of 12 chromosomes:
        genetic_experiment = new MyGenetic(10, 20, 0.85f, 0.3f);
        int geneIndex = 0; //  debug only
        for (Chromosome ll  : genetic_experiment.getChromosomes()) {
          System.out.println(ll.getChromosome() + " : " + genetic_experiment.geneToFloat(geneIndex++));
        }
        int NUM_CYCLES = 500;
        for (int i=0; i<NUM_CYCLES; i++) {
            genetic_experiment.evolve();
            if ((i%(NUM_CYCLES/5))==0 || i==(NUM_CYCLES-1)) {
                System.out.println("Generation " + i);
                genetic_experiment.calcFitness(); // suggested by Rick Hall
                genetic_experiment.sort();        // suggested by Rick Hall
                genetic_experiment.print();
            }
        }
    }
}


