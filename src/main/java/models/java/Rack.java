// Model for a Rack Object

package hpapi.models;
import java.util.ArrayList;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

// These annotations tell the XStream how to deserialize the xml
// This class could be used for another data source as well.
@XStreamAlias("RACK")
public class Rack {
    @XStreamAlias("NAME")
    private String name;
    @XStreamAlias("ID")
    private String id;
    @XStreamAlias("HEIGHT")
    private int height;
    @XStreamAlias("LOCATION")
    private String location;
    @XStreamAlias("SERVERS")
    private ArrayList<Server> servers;

    public Rack() {

    }

    public Rack(String id, String name, int height, String location, ArrayList<Server> servers) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.location = location;
        this.servers = servers;
    }
    public ArrayList<Server> getServers() {
        return this.servers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public int getEmptySpace() {
        int remaining = this.height;
        for(Server server : servers) {
            remaining = remaining - server.getHeight();
        }
        return remaining;
    }

    public Server getServer(String id) {
        for(Server server : servers) {
            if(server.getId().equals(id)) {
                return server;
            }
        }
        return null;
    }

    //Serialize to JSON
    @Override
    public String toString() {
        String text = "{\"name\":" + "\"" + name + "\"," + "\"id\":\"" + id + "\",\"height\":" + height + ",\"location\":\"" + location + "\",";
        text += "\"servers\":[";
        if(servers.size() > 0) {
            for(int i = 0; i < servers.size() - 1; i++) {
                Server server = servers.get(i);
                text += server.toString() + ",";
            }
            text += servers.get(servers.size() - 1).toString();
        }
        text += "]}";
        return text;
    }
}

