//wow I'm fucked
//
//@Trevor
//
//@1/29/21
//
//

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;

import java.awt.GridBagConstraints;  
import java.awt.GridBagLayout;




public class Maze implements MouseListener{
    JFrame frame;
    JPanel panel;
    JLabel label0;
    JTable table;
    DefaultTableModel model;


    public int row;
    public int column;


    mazeObject[][] mazeList;






    public Maze(){
        frame = new JFrame("help");
        panel = new JPanel();
        table = new JTable(10, 10);
        model = new DefaultTableModel(10, 10);
        label0 = new JLabel("wall");

        mazeList = generateMaze(10, 10, mazeList);

    



        frame.add(panel);


        


        table.setCellSelectionEnabled(false);
        table.setRowHeight(40);
        table.setEnabled(false);
        table.addMouseListener(this);
        
        panel.add(table);




        frame.pack();   
        frame.setVisible(true);
    }

    public static mazeObject[][] generateMaze(int maxHeight, int maxWidth, mazeObject[][] list){

       list = new mazeObject[maxWidth][maxHeight];


        for (int h = 0; h < maxHeight; h++){

            for (int w = 0; w < maxWidth; w++){
    
                list[w][h] = new mazeObject(w, h, false);
    
    
            }
        }

        return list;
    
    }

    public static void main(String args[]){

        
        new Maze();

    }

    @Override
    public void mousePressed(MouseEvent e) {


        JTable target = (JTable)e.getSource();
        row = target.rowAtPoint(e.getPoint());
        column = target.columnAtPoint(e.getPoint());

        System.out.println(row + ", " + column);
        System.out.println();

        
        if (model.getValueAt(row, column) == null){

            model.setValueAt("black", row, column);
            mazeList[row][column].wall = true;

        } else {

            model.setValueAt(null, row, column);

            mazeList[row][column].wall = false;
            
        }


        table.getColumnModel().getColumn(column).setCellRenderer(new CellRenderer());

        table.repaint();
        table.setModel(model);
    }   

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }
    
    public void mouseExited(MouseEvent e) {

    }



    /*
    DefaultTableModel tableModel = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {
           //all cells false
           return false;
        }
    };
    */

}
