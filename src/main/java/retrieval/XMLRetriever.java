package hpapi.retrieval;
import hpapi.models.*;
public class XMLRetriever implements DataRetriever {
  private final String fileName = "data.xml";
  private XMLRetriever() {
     
  }
  private static XMLRetriever instance;
  public static synchronized XMLRetriever getInstance() {
    if(instance == null) {
      instance = new XMLRetriever();
    }
    return instance;
  }

  // todo
  public Rack getRackById(int id) {
    return null;
  }
  public Server getServerById(int id) {
    return null; 
  }
  public Rack[] getAllRacks() {
    return null; 
  }
}
