package com.example.eojin;

import java.util.*;
import javax.swing.*;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawBar extends JMenu
{
	
	JMenuItem i_pen, i_line, i_rectengle, i_circle;
	
	public  DrawBar(String name)
	{
		super(name);
		i_pen = new JMenuItem("Pen");
		add(i_pen);
		i_line = new JMenuItem("Line");
		add(i_line);
		i_rectengle = new JMenuItem("Rectengle");
		add(i_rectengle);
		i_circle = new JMenuItem("Circle");
		add(i_circle);
	}
}
