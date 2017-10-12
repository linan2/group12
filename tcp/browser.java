package tcp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.io.IOException;
import java.net.*;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class browser extends Frame{
	JLabel jlabel;
	JTextField jtf;
	JEditorPane edpl;
	public browser(){
		
		super("borwser");
		Container con=getContentPane();
		jlabel=new JLabel("«Î»Î∑√Œ Õ¯÷∑£∫");
		jtf=new JTextField("");
	
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(2,1));
		panel.add(jlabel);
		panel.add(jtf);
		con.add(panel,BorderLayout.NORTH);
		edpl=new JEditorPane();
		edpl.addHyperlinkListener(new MyHyperListerner());
		con.add(new JScrollPane(edpl),BorderLayout.CENTER);
		setSize(600,800);
		
	}
	
	private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}

	void getPage(String site){
		
		try{
			
			edpl.setPage(site);
		}
		catch(IOException e){
			
			JOptionPane.showMessageDialog(this, "¡¨Ω”¥ÌŒÛ","¥ÌŒÛœ‘ æ",JOptionPane.ERROR_MESSAGE);
		}
	}
	class MyEnter implements ActionListener{
	
			public void actionPerformed(ActionEvent e){
				String string =jtf.getText();
				getPage(string);
			}
	}
	
	class MyHyperListerner implements HyperlinkListener{
		
		public void hyperlinkUpdate(HyperlinkEvent e){
			
			if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
				
				String string=e.getURL().toString();
				getPage(string);
			}
		}
		
	}
	public static void main(String args[]){
		
		browser mybrowser=new browser();
		mybrowser.setDefultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

}
