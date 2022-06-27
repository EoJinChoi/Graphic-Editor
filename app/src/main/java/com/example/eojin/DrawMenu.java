package com.example.eojin;

import java.util.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawMenu extends JMenu
{
	static JMenuItem i_pen, i_line, i_rectangle, i_circle;
	MainFrame frame;

	static JMenuItem menuItem = null;
	
	public  DrawMenu(String name)
	{
		super(name);
		i_pen = new JMenuItem("Pen");
		add(i_pen);
		i_pen.addActionListener(new DrawItem.DrawActionListener());
		
		i_line = new JMenuItem("Line");
		add(i_line);
		i_line.addActionListener(new DrawItem.DrawActionListener());
		
		i_rectangle = new JMenuItem("Rectengle");
		add(i_rectangle);
		i_rectangle.addActionListener(new DrawItem.DrawActionListener());
		
		i_circle = new JMenuItem("Circle");
		add(i_circle);
		i_circle.addActionListener(new DrawItem.DrawActionListener());
	}
}
