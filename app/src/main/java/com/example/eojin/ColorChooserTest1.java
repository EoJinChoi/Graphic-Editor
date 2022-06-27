package com.example.eojin;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorChooserTest1 extends JFrame implements ChangeListener
{
	JColorChooser colorChooser = new JColorChooser();
	ColorSelectionModel model = colorChooser.getSelectionModel();

	static boolean colorChange;
	static Color color;


	public ColorChooserTest1()
	{
		setTitle("색상 선택자");
		setLocation(400, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		colorChooser.getSelectionModel().addChangeListener(this);

		add(colorChooser);
	    pack();
	    setVisible(true);
	}
	
	public void stateChanged(ChangeEvent e)
	{
		color = colorChooser.getColor();
	    colorChange = true;
	    DrawItem.c = color;
	}
}
