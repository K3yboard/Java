package br.unip.sicc.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

public class Tela extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon image = new ImageIcon(ConvertePB.getImage());
		setBounds(100, 100, image.getIconWidth()+45, image.getIconHeight()+100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(contentPane);
		JLabel label = new JLabel(image);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		
		JButton btnTransformarEmPb = new JButton("Transformar em PB");
		btnTransformarEmPb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BufferedImage img = ConvertePB.converteIMGPB(ConvertePB.getImage());
				ImageIcon imageIcon = new ImageIcon(img);
				JPanel painel = new JPanel();
				JFrame frame = new JFrame("Imagenova");
				painel.add(new JLabel(imageIcon));
				painel.setVisible(true);
				frame.add(painel);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			}
		});
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(btnTransformarEmPb))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnTransformarEmPb)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(label))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}
