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
}