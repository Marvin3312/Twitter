/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author DE
 */
import javax.swing.*;
import java.awt.*;

public class RegistroUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegistroUI() {
        setTitle("Registro de Usuario");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Nombre de Usuario:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField();
        registerButton = new JButton("Registrar");
        registerButton.addActionListener(e -> registrarUsuario());

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(registerButton);

        add(panel);
    }

    private void registrarUsuario() {
        // Implementa la lógica para registrar un nuevo usuario en la base de datos
        // Aquí puedes utilizar tu clase UsuarioDAO para interactuar con la base de datos
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegistroUI registroUI = new RegistroUI();
            registroUI.setVisible(true);
        });
    }
}
