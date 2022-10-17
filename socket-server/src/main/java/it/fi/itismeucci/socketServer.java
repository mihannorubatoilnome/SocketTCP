package it.fi.itismeucci;

import java.net.Socket;

import java.io.*;
import java.net.*;

public class socketServer extends Thread{
    
    public Socket avvia() throws IOException
    {
        ServerSocket server = new ServerSocket(34567);
        for(;;){
            Socket client = server.accept();
            socketThread t1 = new socketThread(client);
            t1.start();
        }
    }
}
