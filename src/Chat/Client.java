package Chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

class Client implements Runnable {
    Socket socket;
    Scanner in;
    PrintStream out;
    ChatServer server;
    public Client(Socket socket, ChatServer server){
        this.socket = socket;
        this.server = server;
        // запускаем поток
        new Thread(this).start();
    }

    void receive(String message){
        out.println(message);

    }

    public void run() {
        try {
            // получаем потоки ввода и вывода
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            // создаем удобные средства ввода и вывода
            in = new Scanner(is);
            out = new PrintStream(os);

            // читаем из сети и пишем в сеть
            // “ак же теперь можно выбрать им€
            out.println("Welcome to chat! Please, enter your name:");
            String name = in.nextLine();
            out.println("Nice to meet you - " + name);
            String input = " ";
            while (!input.equals("bye")) {
                input = in.nextLine();
                server.sendAll(name + ": " + input);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}