package it.fi.itismeucci;

import java.net.Socket;
import java.util.ArrayList;
import java.io.*;
import java.net.*;

public class socketServer extends Thread{
    
    public final ServerSocket serverPort;
    public final ArrayList<Socket> clients = new ArrayList<>();
    
    public socketServer() throws IOException
    {
        serverPort = new ServerSocket(34567);
    }

    public void avvia() throws IOException
    {
        while (!serverPort.isClosed()){
            try 
            {
                Socket client = serverPort.accept();
                clients.add(client);
                socketThread t1 = new socketThread(client, this);
                t1.start();
            }
            catch (Exception e)
            {
                if (serverPort.isClosed())
                    break;
            }
        }

        System.out.println("Server spento");
    }
}