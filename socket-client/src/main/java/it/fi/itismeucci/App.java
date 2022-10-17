package it.fi.itismeucci;

import java.io.IOException;

public class App 
{
    public static void main( String[] args) throws IOException
    {
        socketClient client = new socketClient();
        client.connect();
        client.send();
    }
}
