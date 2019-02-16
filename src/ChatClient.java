import java.io.*;
import java.net.Socket;

public class ChatClient {
    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter outt;
    static boolean i = false;
    
    public static void main(String[] args) {
        try {
            clientSocket = new Socket("127.0.0.1", 7777);
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outt = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            String word;
            String serverWord;
            System.out.println("Ты подключился к серверу");
            for(;i==false;){
                //System.out.println("/---------");
                word = reader.readLine();
                outt.write(word+"\n");
                outt.flush();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                serverWord = in.readLine();
                System.out.println(serverWord);
            }

        }catch (IOException ex){
            System.out.println("ERROR");
        }
    }
}
