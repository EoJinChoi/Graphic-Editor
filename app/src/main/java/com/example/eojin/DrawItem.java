package com.example.eojin;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class DrawItem extends JPanel
{
   //
   Label move = new Label("마우스 따라다니기",Label.CENTER);
   //
   static String shape =  "pen";
   static Point startP = null;
   static Point endP = null;
   static Color c = Color.BLACK;
   
   static ArrayList<Element> elements = new ArrayList<Element>();
   static ArrayList<Element> clearElements = new ArrayList<Element>();
   ArrayList<Point> vStart;
   static Stack<Element> stack = new Stack<>();
//   static Stack<Element> stack1 = new Stack<>();

   public DrawItem()
   {   
      MyMouseListener ml = new MyMouseListener();
      
      this.addMouseListener(ml); // 리스너
      this.addMouseMotionListener(ml);
   }
   
   class Element
   {
      String name;
      Color clr;
      Integer stroke;
      Point sv;
      Point se;
      ArrayList<Point> start = new ArrayList<Point>();
      
      Element(String name, Color clr, Integer stroke, Point sv, Point se, ArrayList<Point> start)
      {
         this.name = name;
         this.clr = clr;
         this.stroke = stroke;
         this.sv = sv;
         this.se = se;
         
         for(int i=0; i<start.size(); i++)
         {
            this.start.add(start.get(i));
         }
      }
      Element(String name, Color clr, Integer stroke, Point sv, Point se)
      {
         this.name = name;
         this.clr = clr;
         this.stroke = stroke;
         this.sv = sv;
         this.se = se;
         this.start = null;
      }
   }
   
   public void paintComponent(Graphics g){
      super.paintComponent(g); 
      Graphics2D g2= (Graphics2D)g;
      
      if(elements.size() != 0){
         for(int i=0; i<elements.size(); i++){ 
                        
            Element e = elements.get(i);

            g2.setStroke(new BasicStroke(e.stroke,BasicStroke.CAP_ROUND,0));
            
            if(e.name.equals("pen"))
            {
               g2.setColor(e.clr);
               for (int i1 = 0; i1 < e.start.size()-1; i1++)
               {
                     g2.drawLine(e.start.get(i1).x, e.start.get(i1).y, e.start.get(i1+1).x, e.start.get(i1+1).y);
               }
            }
            
            else if(e.name.equals("line"))
            {
               g2.setColor(e.clr);
               g2.drawLine(e.sv.x, e.sv.y, e.se.x, e.se.y);
            }
            else if(e.name.equals("rectangle"))
            {
               g2.setColor(e.clr);
               g2.drawRect(Math.min(e.sv.x,  e.se.x), Math.min(e.sv.y, e.se.y),Math.abs(e.se.x - e.sv.x),Math.abs(e.se.y - e.sv.y));
            }
            else if(e.name.equals("circle"))
            {
               g2.setColor(e.clr);
               g2.drawOval(Math.min(e.sv.x,  e.se.x), Math.min(e.sv.y, e.se.y),Math.abs(e.se.x - e.sv.x),Math.abs(e.se.y - e.sv.y));
            }
            else if(e.name.equals("eraser"))
            {
               g2.setColor(Color.WHITE);
               for (int i1 = 0; i1 < e.start.size()-1; i1++)
               {
                     g2.drawLine(e.start.get(i1).x, e.start.get(i1).y, e.start.get(i1+1).x, e.start.get(i1+1).y);
               }
            }
            else if(e.name.equals("allClear"))
            {
               g2.setColor(Color.WHITE);
               g2.fillRect(0, 0, 1200, 800);
            }
         }
      }
      if(startP != null)
      {
         
         g2.setStroke(new BasicStroke(MainFrame.count,BasicStroke.CAP_ROUND,0));
         if(shape == "pen")
         {
            g2.setColor(c);
            for(int i=0; i<vStart.size()-1; i++)
            {   
               g2.drawLine(vStart.get(i).x, vStart.get(i).y, vStart.get(i+1).x, vStart.get(i+1).y);
            }

         }
            
         if(shape == "line")
         {
            g2.setColor(c);
            g2.drawLine(startP.x, startP.y, endP.x, endP.y);
         }
         if(shape == "rectangle")
         {
            g2.setColor(c);
            g2.drawRect(Math.min(startP.x, endP.x), Math.min(startP.y, endP.y),Math.abs(endP.x - startP.x),Math.abs(endP.y - startP.y));
         }
         if(shape == "circle")
         {                
            g2.setColor(c);
            g2.drawOval(Math.min(startP.x, endP.x), Math.min(startP.y, endP.y),Math.abs(endP.x - startP.x),Math.abs(endP.y - startP.y));
         }
         if(shape == "eraser")
         {
            g2.setColor(Color.WHITE);
            for(int i=0; i<vStart.size()-1; i++)
            {   
               g2.drawLine(vStart.get(i).x, vStart.get(i).y, vStart.get(i+1).x, vStart.get(i+1).y);
            }
         }
         if(shape == "allClear")
         {
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, 1200, 800);
         }
      }
   }
   
   class MyMouseListener extends MouseAdapter implements MouseMotionListener
   {
      public void mousePressed(MouseEvent e){
         startP = e.getPoint();
         vStart = new ArrayList<Point>();
         vStart.add(startP);
      }
      public void mouseDragged(MouseEvent e){
         endP = e.getPoint();
         vStart.add(endP);
         repaint();
      }
      public void mouseReleased(MouseEvent e){
         endP = e.getPoint();
         vStart.add(endP);
         if(shape.equals("pen")||shape.equals("eraser")) {
            Element list = new Element(shape, c, MainFrame.count, startP, endP, vStart);
            elements.add(list);
         }
            
         else if(shape.equals("circle") || shape.equals("line") || shape.equals("rectangle")){
            Element list = new Element(shape, c, MainFrame.count, startP, endP);
            elements.add(list);
         }
         stack.clear();
         clearElements.clear();
         repaint(); 
      }
   }
   
   
   static class DrawActionListener implements ActionListener
   {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            JMenuItem item = (JMenuItem)e.getSource();

            if(item == DrawMenu.i_pen)
            {
               shape = "pen";
               System.out.println("pen");
            }
            else if(item == DrawMenu.i_line)
            {   
               shape = "line";
               System.out.println("line");
            }
            else if(item == DrawMenu.i_rectangle)
            {
               shape = "rectangle";
               System.out.println("rectangle");
            }
            else if(item == DrawMenu.i_circle)
            {
               shape = "circle";
               System.out.println("circle");
            }

            
        }
    }
   
   static class BtnActionListener implements ActionListener
   {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
           JButton button = (JButton)e.getSource();
            if(button == MainFrame.undo)
            {
               if(clearElements.size() != 0)
            {
               for(int i=0; i<clearElements.size(); i++)
               {
                  elements.add(clearElements.get(i));
               }
               clearElements.clear();
               MainFrame.p.repaint();
            }
               else if(elements.size() != 0)
            {
               Element a = elements.remove(elements.size()-1);
               stack.push(a);
               startP = null;
               
               MainFrame.p.repaint();
            }
            }
            if(button == MainFrame.redo)
            {
             if(stack.size() != 0)
             {
                Element b = stack.pop();
                elements.add(b);
                MainFrame.p.repaint();
             }
            }
            if(button == MainFrame.save)
            {
               startP = null;
               shape = "allClear";
               for(int i=0; i<elements.size(); i++)
                  clearElements.add(elements.get(i));
               elements.clear();
               MainFrame.p.repaint();
               
            }
        }
   }
}