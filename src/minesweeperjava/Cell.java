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
    
    public void setId(int id) {
        this.id = id;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void displayValue(){
        if(value==-1){
            button.setText("\u2600");
            button.setBackground(Color.RED);
        }else if(value!=0){
            button.setText(String.valueOf(value));
        }
    }
    
    public void checkCell(){
        button.setEnabled(false);
        displayValue();
        notChecked = false;
        if(value == 0) board.scanForEmptyCells();
        if(value == -1) board.fail();
    }
    
    public void incrementValue(){
        value++;
    }

    public boolean isNotChecked(){
        return notChecked;
    }

    public boolean isEmpty(){
        return isNotChecked() && value==0;
    }

    public void reveal(){
        displayValue();
        button.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkCell();
    }
}
