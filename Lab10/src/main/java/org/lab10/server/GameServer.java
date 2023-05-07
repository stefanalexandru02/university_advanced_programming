package org.lab10.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Virna Stefan Alexandru
 */
public class GameServer implements Runnable {
    ServerSocket socket;
    @Override
    public void run() {
        try {
            socket = new ServerSocket(6666);

            while(true)
            {
                ClientThread clientThread = new ClientThread(socket.accept());
                new Thread(()->{ clientThread.run(); }).run();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
