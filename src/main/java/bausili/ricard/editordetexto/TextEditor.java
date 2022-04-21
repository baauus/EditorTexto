/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bausili.ricard.editordetexto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Ricard
 */
public class TextEditor extends JFrame implements ActionListener {
    
    JTextArea textArea;
    JScrollPane scrollPane;
    JLabel fontLabel;
    JSpinner fontSizeSpinner;
    JButton fontColorButton;
    
    TextEditor(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Editor de Texto");
        this.setSize(600,600);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Calibri", Font.PLAIN,20));  

        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(550,550));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        fontLabel = new JLabel("Font size: ");
        
        fontSizeSpinner = new JSpinner();
        fontSizeSpinner.setPreferredSize(new Dimension(50,25));
        fontSizeSpinner.setValue(20);
        fontSizeSpinner.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent ce) {
                textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN, (int) fontSizeSpinner.getValue()));
            }    
        });
        
        fontColorButton = new JButton("Color");
        fontColorButton.addActionListener(this);
        
        this.add(fontColorButton);
        this.add(fontLabel);
        this.add(fontSizeSpinner);
        this.add(scrollPane);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==fontColorButton){
            JColorChooser colorChooser = new JColorChooser();
            Color color = colorChooser.showDialog(null, "Chooser a color", Color.black);
            textArea.setForeground(color);
        }
    }
}
