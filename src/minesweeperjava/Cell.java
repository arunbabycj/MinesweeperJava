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
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author arun divya
 */
public class Cell implements ActionListener{
    private JButton button;
    private Board board;
    private int value;
    private int id;
    private boolean notChecked;

    public Cell(Board board){
        button = new JButton();
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(20,20));
        button.setMargin(new Insets(0,0,0,0));
        this.board = board;
        notChecked = true;
    }
    
    public JButton getButton() {
        return button;
    }

    public int getValue() {
        return value;
    }
    
    public int getId() {
        return id;
    }
}
