package com.fg.IA.model;

import java.util.BitSet;

public class Chromosome {
	
	private BitSet chromosome;
	private float fitness = -999;

	public Chromosome() { }
	public Chromosome(int num_genes) { chromosome = new BitSet(num_genes); }
	public boolean getBit(int index) {
		return chromosome.get(index);
	}
    public String toString() {
      return "[Chromosome: fitness: " + fitness + ", bit set: " + chromosome+"]";
    }
	public void setBit(int index, boolean value) {
		chromosome.set(index, value);
	}

	public BitSet getChromosome() {
		return chromosome;
	}
	public void setChromosome(BitSet chromosome) {
		this.chromosome = chromosome;
	}
	
	public float getFitness() {
		return fitness;
	}

	public void setFitness(float value) {
		fitness = value;
	}

	public boolean equals(Chromosome c) {
		return chromosome.equals(c.chromosome);
	}
}
