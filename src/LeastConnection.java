import java.util.HashMap;
import java.util.Map;

public class LeastConnection {
    private Map<String, Integer> serverConnections;

    public LeastConnection() {
        this.serverConnections = new HashMap<>();
    }

    public void addServer(String serverName) {

        serverConnections.put(serverName, 0);
    }

    public String getServerWithLeastConnections() {

        int minConnections = Integer.MAX_VALUE;
        String selectedServer = null;

        for (Map.Entry<String, Integer> entry : serverConnections.entrySet()) {
            if (entry.getValue() < minConnections) {
                minConnections = entry.getValue();
                selectedServer = entry.getKey();
            }
        }


        if (selectedServer != null) {
            serverConnections.put(selectedServer, minConnections + 1);
        }

        return selectedServer;
    }
}
