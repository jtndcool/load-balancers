import java.util.ArrayList;
import java.util.List;

public class RoundRobin {
    List<String> servers = new ArrayList<>();
    int currIndex;

    public RoundRobin(List<String> servers) {
        this.servers = servers;
        this.currIndex = 0;
    }

    String getNextServer() {
        String serverName = servers.get(this.currIndex);
        if (this.currIndex >= servers.size() - 1) {
            this.currIndex = 0;
        } else {
            this.currIndex++;
        }
        return serverName;
    }
}