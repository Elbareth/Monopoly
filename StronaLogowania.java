/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author izab
 */
public class StronaLogowania extends JFrame{
    private JLabel tlo;
    private JLabel lista;
    private JTextField login;
    private JButton ok;
    private JButton start;
    private JList listaUzytkownikow;
    private DefaultListModel modelListy;
    private JScrollPane scroll;       
    public StronaLogowania(){
        
    }
    public void Wyglad(){
        setTitle("Monopoly");
        setSize(590,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        try{
            setIconImage(ImageIO.read(new File("obrazy/icon.jpg"))); // ustawiam ikone
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
        tlo =new JLabel(new ImageIcon("obrazy/tlo.jpg")); // ustawiam tlo
        add(tlo);
        login = new JTextField();
        login.setBounds(170, 200, 150, 30);
        tlo.add(login);
        ok = new JButton("OK");
        ok.setBounds(330,200,70,30);
        ok.addActionListener(new Zatwierdz());
        tlo.add(ok);
        lista = new JLabel("Lista Użytkowników:");
        lista.setForeground(Color.red);        
        lista.setBounds(100,450,400,50);
        tlo.add(lista);
        modelListy = new DefaultListModel();
        listaUzytkownikow = new JList(modelListy);
        listaUzytkownikow.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        scroll = new JScrollPane(listaUzytkownikow);
        scroll.setBounds(100, 500, 400,100);
        tlo.add(scroll);
        start = new JButton("Start");
        start.setBounds(200, 620, 150, 30);
        start.addActionListener(new Start());
        tlo.add(start);
        setVisible(true);
    }
    class Zatwierdz implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // Tutaj łączym się z serwerem
            login.setText("");
        }        
    }
    class Start implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // zaczynamy rozgrywke
        }        
    }
}
