package com.fg.IA.controller;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

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
//classe teste
public class TestGenetic extends ApplicationFrame {		
   public static MyGenetic genetic_experiment;
   Chromosome chromosome = new Chromosome();
   
   
   public TestGenetic (String title, DefaultPieDataset dataset) {
       super(title);
       JPanel panel = new JPanel(new GridLayout(2, 2));
       JFreeChart chart1 = ChartFactory.createPieChart("Chart 1", dataset, false, false, false);
       panel.add(new ChartPanel(chart1));
       panel.setPreferredSize(new Dimension(800, 600));
       setContentPane(panel);

   }
   
    public static void main(String args[]) {    	
        // we will use chromosomes with 10 1 bit genes per
        // chromosomes, and a population of 12 chromosomes:
    	
        genetic_experiment = new MyGenetic(10, 5, 0.4f, 0.7f);
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
        
        TestGenetic demo = new TestGenetic("Gráfico dos melhores individuos por população", genetic_experiment.dataset);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}


