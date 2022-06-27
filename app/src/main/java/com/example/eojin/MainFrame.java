package com.example.eojin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.*;
import javax.swing.*;

public class MainFrame extends JFrame  
{
	JMenuBar menuBar;
	DrawMenu drawMenu;
	FunctionMenu functionMenu;
	
	static JRadioButton black, red, blue, green;
	static int count = 3;
	static JButton undo, redo;
	static JPanel p;
	static JButton color;
	static JButton save;
	
	private void createFrame()
	{
		super.setLayout(new BorderLayout());
		p = new DrawItem();
		p.setBackground(Color.WHITE);
		add(p);
		JPanel pn = new JPanel();
		pn.setLayout(new FlowLayout());
		pn.setBounds(0, 0, 1000, 50);
		pn.setBackground(Color.LIGHT_GRAY);
		add(pn, BorderLayout.NORTH);
		
		// undo/redo 버튼
		undo = new JButton("←");
		undo.addActionListener(new DrawItem.BtnActionListener());
		redo = new JButton("→");
		redo.addActionListener(new DrawItem.BtnActionListener());
		pn.add(undo);
		pn.add(redo);
		
		//color 버튼
		color = new JButton("COLOR");
		color.addActionListener(new ColorItem.ColorActionListener());
		pn.add(color);
		
		// 저장
		save = new JButton("All Clear");
		save.addActionListener(new DrawItem.BtnActionListener());
		pn.add(save);
		
		// 선 굵기
		JButton btn1 = new JButton("+");
		JButton btn2 = new JButton("-");
		JLabel txt1=new JLabel("3");
		
		txt1.setHorizontalAlignment(JLabel.CENTER); 
		pn.add(btn2);
		pn.add(txt1);
		pn.add(btn1);
		
		ActionListener btn1_action = new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				count += 1;
				txt1.setText(String.valueOf(count));				
			}
		};
		btn1.addActionListener(btn1_action);
		
		ActionListener btn2_action = new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				if(count <= 1)
					txt1.setText("1");
				else
				{
					count -= 1;
					txt1.setText(String.valueOf(count));
				}				
			}
		};
		btn2.addActionListener(btn2_action);
 
		// MenuBar
		menuBar = new JMenuBar();
		drawMenu = new DrawMenu("Draw");
		functionMenu = new FunctionMenu("Function");
		setJMenuBar(menuBar);

		menuBar.add(drawMenu);
		menuBar.add(functionMenu);
	
		setSize(1200, 800);
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MainFrame mainFrame = new MainFrame();
		mainFrame.createFrame();
	}

}
