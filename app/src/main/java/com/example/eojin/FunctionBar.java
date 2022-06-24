package com.example.eojin;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FunctionBar
{
	MainFrame mf = new MainFrame();
	JMenuItem i_eraser, i_save;
	
	public void setFunctionBar()
	{
		JMenu m_function = new JMenu("Function");
		mf.mb.add(m_function);
		
		i_eraser = new JMenuItem("Eraser");
		m_function.add(i_eraser);
		JMenuItem i_save = new JMenuItem("Save");
		m_function.add(i_save);

		mf.mb.add(m_function);
		mf.setJMenuBar(mf.mb);
	}
}
