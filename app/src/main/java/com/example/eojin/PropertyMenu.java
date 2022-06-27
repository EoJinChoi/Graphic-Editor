package com.example.eojin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

//import com.example.eojin.MainFrame.MyActionListener;

public class PropertyBar
{
	MainFrame mf = new MainFrame();
	JMenuItem i_size, i_color;
	
	public void setPropertyBar()
	{
		JMenu m_property = new JMenu("Property");
		mf.mb.add(m_property);
		
		i_size = new JMenuItem("Size");
//		i_size.addActionListener(new MyActionListener());
		m_property.add(i_size);
		
		i_color = new JMenuItem("Color");
		m_property.add(i_color);

		mf.mb.add(m_property);
		mf.setJMenuBar(mf.mb);
	}
	
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
}
