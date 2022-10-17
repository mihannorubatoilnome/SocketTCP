package it.fi.itismeucci;

import java.io.*;
import java.net.*;

public class socketThread extends Thread{

    protected final Socket client;

    public socketThread(Socket client){
        this.client = client;
    }

    @Override
    public void run() {
        try{
            for(;;){
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                String recv = in.readLine();
                if(recv == "FINE"){
                    System.out.println("\nConnessione terminata");
                    client.close();
                }
                System.out.print("\nStringa ricevuta: " + recv);
                String modifiedRecv = recv.toUpperCase();
                out.writeBytes(modifiedRecv + '\n');        
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
