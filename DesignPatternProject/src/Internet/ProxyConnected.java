package Internet;

import java.util.ArrayList;
import java.util.List;

public class ProxyConnected implements Connected{
    private HostServer internet = new HostServer();
    private static List<String> server;

    static{
        server = new ArrayList<String>();
    }

    @Override
    public void connectTo(String serverhost) throws Exception{
        if(server.contains(serverhost.toLowerCase())){    
        }
          internet.connectTo(serverhost);
    }
}


