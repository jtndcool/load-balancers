import java.util.HashMap;
import java.util.Map;

public class LeastResponseTime {
    private Map<String, Long> serverResponseTimes;

    public LeastResponseTime() {
        this.serverResponseTimes = new HashMap<>();
    }

    public void addServer(String serverName) {

        serverResponseTimes.put(serverName, 0L);
    }

    public String getServerWithLeastResponseTime() {

        long minResponseTime = Long.MAX_VALUE;
        String selectedServer = null;

        for (Map.Entry<String, Long> entry : serverResponseTimes.entrySet()) {
            if (entry.getValue() < minResponseTime) {
                minResponseTime = entry.getValue();
                selectedServer = entry.getKey();
            }
        }


        if (selectedServer != null) {
            serverResponseTimes.put(selectedServer, minResponseTime + 1);
        }

        return selectedServer;
    }
}
