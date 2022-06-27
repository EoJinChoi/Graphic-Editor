package com.example.eojin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FunctionMenu extends JMenu
{	
	static JMenuItem i_eraser;
	
	public FunctionMenu(String name)
	{
		super(name);
		i_eraser = new JMenuItem("Eraser");
		add(i_eraser);
		i_eraser.addActionListener(new EraseActionListener());
	}
	
	static class EraseActionListener implements ActionListener
	{
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            JMenuItem item = (JMenuItem)e.getSource();

            if(item == i_eraser)
            {
            	DrawItem.shape = "eraser";
            }
        }
    }
}
