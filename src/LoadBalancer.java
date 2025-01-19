import java.util.ArrayList;
import java.util.List;

public class LoadBalancer {
    public static void main(String[] args) throws InterruptedException {
        List<String> servers = new ArrayList<>(List.of("Server1", "Server2", "Server3", "Server4", "Server5"));
        RoundRobin roundRobin = new RoundRobin(servers);
        for (int i = 1; i < 20; i++) {
            Thread.sleep(1000);
            System.out.println("Request " + i + " is sent to" + roundRobin.getNextServer());
        }
    }
}
