import java.util.HashMap;
import java.util.Map;

class Server {
    String name;
    double cpuLoad;

    public Server(String name) {
        this.name = name;
        this.cpuLoad = 0.0;
    }


    public void updateCpuLoad(double load) {
        this.cpuLoad = load;
    }

    public double getCpuLoad() {
        return this.cpuLoad;
    }

    public String getName() {
        return this.name;
    }
}

class ResourceBased {
    private Map<String, Server> servers;

    public ResourceBased() {
        this.servers = new HashMap<>();
    }


    public void addServer(Server server) {
        servers.put(server.getName(), server);
    }


    public Server getServerWithMostResources() {
        Server bestServer = null;
        double lowestLoad = Double.MAX_VALUE;

        for (Server server : servers.values()) {
            if (server.getCpuLoad() < lowestLoad) {
                lowestLoad = server.getCpuLoad();
                bestServer = server;
            }
        }
        return bestServer;
    }


    public void handleRequest() {
        Server bestServer = getServerWithMostResources();
        if (bestServer != null) {
            System.out.println("Routing request to server: " + bestServer.getName() + " with current CPU load: " + bestServer.getCpuLoad() + "%");

        } else {
            System.out.println("No servers available.");
        }
    }
}

class ResourceBasedLoadBalancerExample {
    public static void main(String[] args) {
        ResourceBased loadBalancer = new ResourceBased();


        Server server1 = new Server("Server1");
        Server server2 = new Server("Server2");
        Server server3 = new Server("Server3");

        loadBalancer.addServer(server1);
        loadBalancer.addServer(server2);
        loadBalancer.addServer(server3);


        server1.updateCpuLoad(30.0);
        server2.updateCpuLoad(50.0);
        server3.updateCpuLoad(20.0);


        loadBalancer.handleRequest();
    }
}