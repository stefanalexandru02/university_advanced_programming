package org.lab10.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

/**
 * @author Virna Stefan Alexandru
 */
public class ClientThread implements Runnable {

    Socket clientSocket;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Invoking input stream via getInputStream()
            // method by creating DataInputStream class
            // object
            DataInputStream dis
                    = null;

            dis = new DataInputStream(clientSocket.getInputStream());

            String str = (String)dis.readUTF();

            // Display the string on the console
            System.out.println("message= " + str);

            DataOutputStream d = new DataOutputStream(
                    clientSocket.getOutputStream());

            if(str.equals("stop"))
            {
                d.writeUTF("Server stopped");
                d.flush();
                d.close();
            }

            d.writeUTF("Server received the request ... ");
            d.flush();
            d.close();
        } catch (EOFException e){
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
