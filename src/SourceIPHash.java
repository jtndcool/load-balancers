import java.util.HashMap;
import java.util.Map;

public class SourceIPHash {
    private Map<String, String> ipToServerMap;

    public SourceIPHash() {
        this.ipToServerMap = new HashMap<>();
    }

    public void addServer(String serverName) {

        ipToServerMap.put(serverName, serverName);
    }

    public String getServerForIp(String sourceIp) {

        int hash = sourceIp.hashCode();


        String[] servers = ipToServerMap.keySet().toArray(new String[0]);


        int serverIndex = Math.abs(hash) % servers.length;


        return servers[serverIndex];
    }
}
