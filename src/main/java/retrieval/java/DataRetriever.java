// The interface for a DataRetriever.

package hpapi.retrieval;
import hpapi.models.*;
import java.util.ArrayList;
public interface DataRetriever {
    Rack getRackById(String id);
    Data getAllRacks();
    Server getServerById(String id);
}

