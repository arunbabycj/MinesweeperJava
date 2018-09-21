/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperjava;

/**
 *
 * @author arun divya
 */
import minesweeper.Cell;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board {
    private Cell[][] cells;
    private int cellID = 0;
    private int side = 8;
    private int limit = side-2;
    
public void setBoard(){
        JFrame frame = new JFrame();
        frame.add(addCells());

        plantMines();
        setCellValues();

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(side,side));
        cells = new Cell[side][side];
        for(int i = 0; i< side; i++){
            for(int j = 0; j<side; j++){
                cells[i][j] = new Cell(this);
                cells[i][j].setId(getID());
                panel.add(cells[i][j].getButton());
            }
        }
        return panel;
    }
    
    public void plantMines(){
        ArrayList<Integer> loc = generateMinesLocation(10);
        for(int i : loc){
            getCell(i).setValue(-1);
        }
    }
    /*Choose rendom places for mines*/
    public ArrayList<Integer> generateMinesLocation(int q){
        ArrayList<Integer> loc = new ArrayList<Integer>();
        int random;
        for(int i = 0; i<q;){
            random = (int)(Math.random()* (side*side));
            if(!loc.contains(random)){
                loc.add(random);
                i++;
            }
        }
        return loc;
    }    
}