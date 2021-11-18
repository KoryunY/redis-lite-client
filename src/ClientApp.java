
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientApp {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("type redis-cli to connect");
        while(!in.readLine().equals("redis-cli")){
            System.out.println("Invalid Command\n"+"Please type redis-cli to connect");
        }
        Client client = new Client();
        client.startConnection("127.0.0.1", 4444);
        String resp = in.readLine();
        while (!resp.equals("ex")) {
            resp = client.sendMessage(resp);
            System.out.println(resp);
            resp = in.readLine();
        }
        client.stopConnection();
    }
}
