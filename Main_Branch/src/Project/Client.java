package Project;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class Client implements Runnable{
    String clientName;
    BufferedReader reader;
    BufferedWriter writer;

    final static ArrayList<Client> clients = new ArrayList<>();

    Client(Socket sc){
        try {
            OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
            writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(sc.getInputStream());
            reader = new BufferedReader(isr);

            clientName = reader.readLine();
            clients.add(this);

            System.out.println("Client " + clientName + " connected.");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        while(true){
            try {
                String data = reader.readLine();
                data = clientName + ": " + data + "\n";
                //here yhe code:
                {
                    try {
                        FileWriter fw = new FileWriter("C:\\Users\\Rupok\\Desktop\\A_OOP\\TechShop\\src\\Files\\message.txt", true);
                        BufferedWriter writer = new BufferedWriter(fw);
                        writer.append(data);
                        writer.close();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
                synchronized (clients){
                    for(Client client: clients){
                        client.writer.write(data);
                        client.writer.flush();
                    }
                }
            }
            catch (SocketException e){
                break;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
