package hpapi.retrieval; 
import hpapi.models.*;
import java.util.ArrayList;
public interface DataRetriever {
  Rack getRackById(int id);
  Data getAllRacks();
  Server getServerById(int id);
}

