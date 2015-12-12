package hpapi.retrieval; 
import hpapi.models.*;
public interface DataRetriever {
  Rack getRackById(int id);
  Rack[] getAllRacks();
  Server getServerById(int id);
}

