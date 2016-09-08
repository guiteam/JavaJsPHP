package org.iii.www;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SoftwareView extends JFrame {

	private JButton upspeed, downspeed;
	private JLabel view;
	private int speed;
	private DrawerCircle drawer ;

	SoftwareView() {
		super("accelerator View");
		speed=10 ;
		upspeed = new JButton("Up");
		downspeed = new JButton("Down");
		view = new JLabel("",SwingConstants.CENTER);
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new BorderLayout());
		JPanel east = new JPanel(new FlowLayout(FlowLayout.LEFT)) ;
		JPanel west = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel center =new JPanel(new FlowLayout(FlowLayout.CENTER));
		top.add(east, BorderLayout.EAST);
		top.add(west, BorderLayout.WEST);
		top.add(center,BorderLayout.CENTER);
		east.add(upspeed);
		west.add(downspeed);
		center.add(view);
		add(top, BorderLayout.NORTH) ;
		
		drawer = new DrawerCircle();
		
		

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		view.setFont(new Font("標楷體",Font.LAYOUT_RIGHT_TO_LEFT,50));
		view.setText(""+speed);
		
		downspeed.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				downspeed();
				
			}
		});
		upspeed.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				upspeed(30);
			}
		});
	}

	protected void downspeed() {
		// TODO Auto-generated method stub
		if(speed>1){
			speed = (int) (speed < 0 ? 0 : speed * 0.8);
			view.setText(""+speed);
			return ;
		} else speed = 0 ;
		
	}

	protected void upspeed(int a) {
		// TODO Auto-generated method stub
		if(speed>200){
			speed=200 ;
		} else 
		speed = (int) (speed < 0 ? speed : speed * 1.2 + a);
		view.setText(""+speed);
		return ;
	}

	private class Bike {
		private double speed;
		private Color color;
		int count;
		private double speedA;

		Bike(int count, double speed, Color color) {
			this.count = count;
			this.speed = speed;
			this.color = color;
			speedA = 0;
		}

		void upseed(int a) {

			speedA = (speedA > speed ? speed : speedA * 1.2 + a);

		}

		void downseed() {
			speedA = (speedA < 0 ? 0 : speedA * 0.2);
		}

		double speedStatic() {
			return speedA;

		}

		void txt() {
			System.out.println("ok");
		}
	}
}
