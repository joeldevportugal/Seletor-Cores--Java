package Selector;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Selector extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField TxtHexa;
    private JPanel Pcor;
    private JSlider SVermelho;
    private JSlider SVerde;
    private JSlider SAzul;
    private JLabel lblVermelho;
    private JLabel lblVerde;
    private JLabel lblAzul;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Selector frame = new Selector();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Selector() {
    	setTitle("Selector DevJoel Portugal 2024 ©");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Pcor = new JPanel();
        Pcor.setBackground(new Color(0, 0, 0));
        Pcor.setBounds(10, 11, 175, 179);
        contentPane.add(Pcor);

        SVermelho = new JSlider();
        SVermelho.setMaximum(255);
        SVermelho.setBounds(195, 41, 229, 20);
        contentPane.add(SVermelho);

        SVerde = new JSlider();
        SVerde.setMaximum(255);
        SVerde.setBounds(195, 102, 229, 20);
        contentPane.add(SVerde);

        SAzul = new JSlider();
        SAzul.setMaximum(255);
        SAzul.setBounds(195, 168, 229, 20);
        contentPane.add(SAzul);

        lblVermelho = new JLabel("Vermelho 0");
        lblVermelho.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblVermelho.setBounds(195, 16, 86, 14);
        contentPane.add(lblVermelho);

        lblVerde = new JLabel("Verde 0");
        lblVerde.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblVerde.setBounds(195, 72, 86, 14);
        contentPane.add(lblVerde);

        lblAzul = new JLabel("Azul 0");
        lblAzul.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblAzul.setBounds(195, 143, 86, 14);
        contentPane.add(lblAzul);

        TxtHexa = new JTextField();
        TxtHexa.setFont(new Font("Tahoma", Font.PLAIN, 17));
        TxtHexa.setBounds(10, 201, 113, 28);
        contentPane.add(TxtHexa);
        TxtHexa.setColumns(10);

        JButton BtnCopiar = new JButton("Copiar");
        BtnCopiar.setBounds(133, 201, 89, 28);
        contentPane.add(BtnCopiar);

        // Adicionando listeners aos sliders
        SVermelho.addChangeListener(e -> {
            atualizarCor();
            atualizarLabels();
        });

        SVerde.addChangeListener(e -> {
            atualizarCor();
            atualizarLabels();
        });

        SAzul.addChangeListener(e -> {
            atualizarCor();
            atualizarLabels();
        });

        // Adiciona um ActionListener para o botão Copiar
        BtnCopiar.addActionListener(e -> {
            // Obtém o conteúdo do campo TxtHexa
            String textoHexadecimal = TxtHexa.getText();

            // Copia o conteúdo para a área de transferência
            StringSelection stringSelection = new StringSelection(textoHexadecimal);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);

            // Exibe uma mensagem de confirmação
            JOptionPane.showMessageDialog(this, "Texto copiado para a área de transferência.", "Copiado", JOptionPane.INFORMATION_MESSAGE);
        });
    }

 // Método para atualizar a cor de fundo do painel com base nos valores dos sliders
    private void atualizarCor() {
        int red = SVermelho.getValue();
        int green = SVerde.getValue();
        int blue = SAzul.getValue();
        Color novaCor = new Color(red, green, blue);
        Pcor.setBackground(novaCor);

        // Calcula o valor hexadecimal e atualiza o campo TxtHexa
        String hex = String.format("#%02X%02X%02X", red, green, blue);
        TxtHexa.setText(hex); // Aqui está a adição para atualizar o campo de texto com o valor hexadecimal
    }

    // Método para atualizar os valores das labels com base nos valores dos sliders
    private void atualizarLabels() {
        lblVermelho.setText("Vermelho " + SVermelho.getValue());
        lblVerde.setText("Verde " + SVerde.getValue());
        lblAzul.setText("Azul " + SAzul.getValue());
    }
}


        
        
        
        


