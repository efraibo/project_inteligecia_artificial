package com.fg.IA.controller;

import com.fg.IA.model.Genetic;

public class MyGenetic extends Genetic{	
	
	 MyGenetic(int num_g, int num_c, float crossover_fraction,
             float mutation_fraction) {
       super(num_g, num_c, crossover_fraction, mutation_fraction);
   }
   private float fitness(float x) {
       return (float)(Math.sin(x) * Math.sin(0.4f * x) * Math.sin(3.0f * x));
   }
   float geneToFloat(int chromosomeIndex) {
       int base = 1;
       float x = 0;
       for (int j=0; j<numGenesPerChromosome; j++)  {
           if (getGene(chromosomeIndex, j)) {
               x += base;
           }
           base *= 2;
       }
       x /= 102.4f;
       return x;
   }
   public void calcFitness() {
       for (int i=0; i<numChromosomes; i++) {
           float x = geneToFloat(i);
           getChromosomes().get(i).setFitness(fitness(x));
       }
   }

   public void print() {
       float sum = 0.0f;
       for (int i=0; i<numChromosomes; i++) {
           float x = geneToFloat(i);
           sum += getChromosomes().get(i).getFitness();
           if (true) { // (i < (numChromosomes / 2)) {  // show best half of chromosomes
               System.out.print("Fitness for chromosome ");
               System.out.print(i);
               System.out.print(" is ");
               System.out.println(getChromosomes().get(i).getFitness() + ", occurs at x=" + x);
           }
       }
       sum /= (float)numChromosomes;
       System.out.println("Average fitness=" + sum +
       		           " and best fitness for this generation:" +
       		           getChromosomes().get(0).getFitness());
   }
}
