package projetoredes;
import java.io.*;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Cliente {
    public static void main(String[] args) throws IOException{
        System.out.println("Cliente");
        Socket socket = new Socket("localhost", 5000);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        EscutaThread escuta = new EscutaThread(in);
        escuta.start();
        String entrada = "";
        while(true){
            entrada = JOptionPane.showInputDialog(null, "Mensagem para o servidor", 
                    "Cliente", JOptionPane.INFORMATION_MESSAGE);
            out.println(entrada);
            System.out.println("Cliente escreve: " + entrada);
        }
    }
    
}
