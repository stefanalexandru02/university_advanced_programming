package org.lab10.client;

import java.io.*;
import java.net.Socket;

/**
 * @author Virna Stefan Alexandru
 */
public class GameClient implements Runnable{

    @Override
    public void run() {
        try {
            while(true) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(System.in));
                String command = reader.readLine().toLowerCase();

                if(command.equals("exit")) {break;}

                Socket soc = new Socket("localhost", 6666);

                DataOutputStream d = new DataOutputStream(
                        soc.getOutputStream());
                var inputStream = new DataInputStream(soc.getInputStream());

                d.writeUTF(command);
                System.out.println(inputStream.readUTF());
                d.flush();
                d.close();
                soc.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
