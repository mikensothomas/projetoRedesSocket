package projetoredes;

import java.io.*;
import javax.swing.*;
import java.net.*;
public class Servidor {
    public static void main(String[] args) throws IOException{
        System.out.println("Servidor");
        ServerSocket socketServidor = new ServerSocket(5000);
        Socket socketCliente = socketServidor.accept();
        PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
        EscutaThread escuta = new EscutaThread(in);
        escuta.start();
        String entrada;
        while(true){
            entrada = JOptionPane.showInputDialog(null, "Mensagem para o cliente", 
                    "Servidor", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Servidor escreve: " + entrada);
            out.println(entrada);
        }
    }
    
}
