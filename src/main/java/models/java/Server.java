// This is the model for a server object

package hpapi.models;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
@XStreamAlias("SERVER")
public class Server {
    @XStreamAlias("SERVER_ID")
    private String id;
    @XStreamAlias("SERVER_NAME")
    private String name;
    @XStreamAlias("SERVER_HEIGHT")
    private int height;

    public Server() {
      // XStream uses empty constructors
    }

    public Server(String id, String name, int height) {
        this.name = name;
        this.height = height;
        this.id = id;
    }
    public String getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHeight() {
        return this.height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return "{\"name\":\"" + name + "\",\"id\":\"" + id + "\",\"height\":" + height + "}";
    }
}

