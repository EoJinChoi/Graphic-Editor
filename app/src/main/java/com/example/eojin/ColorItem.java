package com.example.eojin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.example.eojin.DrawItem.Element;


public class ColorItem 
{
	static class ColorActionListener implements ActionListener
	{
        @Override
        public void actionPerformed(ActionEvent e) 
        {
        	JButton button = (JButton)e.getSource();
            
        	if(button == MainFrame.color)
        	{
        		new ColorChooserTest1();
        	}
        }
	}
}
