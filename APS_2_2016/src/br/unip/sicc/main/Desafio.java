package br.unip.sicc.main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Desafio extends JFrame {
    private JPanel Jp = new JPanel();
    private JLabel Jl1 = new JLabel("Foto");
    private JLabel Jl2 = new JLabel();
    private JLabel Jl3 = new JLabel();
    private JButton Jb1 = new JButton();
    private JButton Jb2 = new JButton();
    private ImageIcon icone = new ImageIcon();
    public Desafio() {
        criaJFrame();
        criaJButton();
        criaJLabel();
        criaJLabel();
    }
    public void Icones() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Imagem para o Panel");
    }
    public void criaJFrame() {
        setVisible(true);
        setSize(350, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());
        Jp.setPreferredSize(new Dimension(300, 250));
        Jp.setBorder(BorderFactory.createEtchedBorder());
        getContentPane().add(Jp);
    }
    public void criaJButton() {
        Jb1.setVisible(true);
        Jb2.setVisible(true);
        Jb1.setSize(130, 25);
        Jb2.setSize(130, 25);
        Jb1.setText("Cor");
        Jb2.setText("Foto");
        getContentPane().add(Jb1);
        getContentPane().add(Jb2);
        Jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setFileFilter(new FileNameExtensionFilter("Imagem", "jpg", "jpeg", "gif"));
                jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                jfc.showDialog(jfc, "Selecione");
                JOptionPane.showMessageDialog(null, jfc.getSelectedFile());
            }
        });
        Jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JColorChooser jcc = new JColorChooser();
                Color c = jcc.showDialog(Jp, "Seleção de Cores", Color.yellow);
                Jp.setBackground(c);
            }
        });
    }
    public void criaJLabel() {
        Jl1.setVisible(true);
        Jl2.setVisible(true);
        Jl3.setVisible(true);
        Jl1.setSize(80, 20);
        Jl2.setSize(80, 20);
        Jl3.setSize(80, 20);
        Jl1.setLocation(300, 300);
        Jl2.setLocation(400, 300);
        Jl3.setLocation(450, 300);
        Jl1.setText("Foto");
        Jl2.setText("Nome");
        Jl3.setText("Sel.Foto");
        Jp.add(Jl1);
        getContentPane().add(Jl2);
        getContentPane().add(Jl3);
    }
    public static void main(String[] args) {
        new Desafio();
    }
}