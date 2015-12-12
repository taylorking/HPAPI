// The class I am using to get XML out of the file sent to me.

package hpapi.retrieval;
import hpapi.models.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XMLRetriever implements DataRetriever {
    private final String fileName = "data.xml";
    private Data data;
    // Private constructor because this class is used as a singleton
    private XMLRetriever() {
        XStream stream = new XStream();
        String text = "";
        try {
            FileReader fr = new FileReader("data.xml");
            // Read the text in to be parsed as xml
            BufferedReader reader  = new BufferedReader(fr);
            String line;
            while((line = reader.readLine()) != null) {
                text += line;
            }
            XStream xstream = new XStream(new StaxDriver());
            configureXMLAliases(xstream);
            data = (Data)xstream.fromXML(text);
        } catch (FileNotFoundException ex) {
            System.out.println("data.xml not found!");
        } catch (IOException ex) {
            System.out.println("IOException: fatal error. ");
            System.exit(1);
        }
    }


    private void configureXMLAliases(XStream xstream) {
        xstream.processAnnotations(Rack.class);
        xstream.processAnnotations(Server.class);
        xstream.processAnnotations(Data.class);
    }

    // I use this class as a singleton
    // In the future this will be necessary if we want to potentially write and change the file.
    private static XMLRetriever instance;

    public static synchronized XMLRetriever getInstance() {
        if(instance == null) {
            instance = new XMLRetriever();
        }
        return instance;
    }

    // todo
    public Rack getRackById(String id) {
        for(Rack rack : data.getRacks()) {
            if(rack.getId().equals(id)) {
                return rack;
            }
        }
        return null;
    }
    public Server getServerById(String id) {
        for(Rack rack : data.getRacks()) {
            for(Server server : rack.getServers()) {
                if(server.getId().equals(id)) {
                    return server;
                }
            }
        }
        return null;
    }
    public Data getAllRacks() {
        return data;
    }
}
