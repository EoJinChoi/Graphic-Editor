package com.example.eojin;

import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class MainFrame extends JFrame 
{
	JMenuBar mb;
	DrawBar drawBar;
	JMenuItem drawItem;
//	 JMenuItem i_pen, i_line, i_rectengle, i_circle, i_size, i_color, i_eraser, i_save;
//	 Button b = new Button();
	 
	
	public MainFrame()
	{
		super.setTitle("Graphic Editor");
		
	}
	
//	public  void setDrawBar()
//	{
//		f.setJMenuBar(mb);
//
//		JMenu m_draw = new JMenu("Draw");
//		mb.add(m_draw);
//		
//		i_pen = new JMenuItem("Pen");
//		m_draw.add(i_pen);
//		i_line = new JMenuItem("Line");
//		m_draw.add(i_line);
//		i_rectengle = new JMenuItem("Rectengle");
//		m_draw.add(i_rectengle);
//		i_circle = new JMenuItem("Circle");
//		m_draw.add(i_circle);
//
//		mb.add(m_draw);
//		setJMenuBar(mb);
//		  
//	}
//	
//	public void setPropertyBar()
//	{
//		JMenu m_property = new JMenu("Property");
//		mb.add(m_property);
//		
//		i_size = new JMenuItem("Size");
//		i_size.addActionListener(new MyActionListener());
//		m_property.add(i_size);
//		
//		i_color = new JMenuItem("Color");
//		m_property.add(i_color);
//
//		mb.add(m_property);
//		setJMenuBar(mb);
//	}
//	
//	public void setFunctionBar()
//	{
//		JMenu m_function = new JMenu("Function");
//		mb.add(m_function);
//		
//		i_eraser = new JMenuItem("Eraser");
//		m_function.add(i_eraser);
//		JMenuItem i_save = new JMenuItem("Save");
//		m_function.add(i_save);
//
//		mb.add(m_function);
//		setJMenuBar(mb);
//	}
//	
//	
//	class MyActionListener implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JMenuItem item = (JMenuItem)e.getSource();
//
//            if(item == i_size)
//            {
//                System.out.println("hello");
//            }
//            
//        }
//        
//    }
	private void createFrame() {
		mb = new JMenuBar();
		drawBar = new DrawBar("Draw tool");
//		drawItem = new JMenuItem("Pen");
		setJMenuBar(mb);
//		db.setDrawBar();
//		mb.add(db);
		
//		pb.setPropertyBar();
//		fb.setFunctionBar();
//		mb.set
		
//		drawBar.add(drawItem);
		mb.add(drawBar);
//		mb.setBounds(0, 0, 800, 30);
		
//		add(mb);
		
		setSize(800, 600);
		
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame m = new MainFrame();
		m.createFrame();
	}

}
