import socketio.ServerSocket;
import socketio.Socket;

import java.io.IOException;

public class EchoServer {

    private int port = 25565;
    private ServerSocket sSocket;
    private Socket cSocket;
    private int clientNr;

    EchoServer() throws IOException {

        sSocket = new ServerSocket(port);

        cSocket = sSocket.accept();
    }

    void kommunizieren() throws IOException {

        do {

            //System.out.println("warte zeichen...");

            String temp = cSocket.readLine();

            //System.out.println("erkannt...");

            System.out.println(temp);


            if (temp.endsWith("over")) break;

            cSocket.write(temp + "\n");

        }while(true);

    }

    void beenden() throws IOException {

        cSocket.close();
        sSocket.close();

    }

    static void main() throws IOException {

        EchoServer es = new EchoServer();

        es.kommunizieren();

        es.beenden();

    }

}
