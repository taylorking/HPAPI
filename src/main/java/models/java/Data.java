// Model for the enclosing XML object with <RACKS></RACKS> in it

package hpapi.models;
import java.util.ArrayList;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
@XStreamAlias("RACKS")
public class Data {
    @XStreamImplicit(itemFieldName="RACK")
    private ArrayList<Rack> racks;
    public Data() {
    }
    public Data(ArrayList<Rack> racks) {
        this.racks = racks;
    }
    public ArrayList<Rack> getRacks() {
        return this.racks;
    }
    public void setRacks(ArrayList<Rack> racks) {
        this.racks = racks;
    }
    //This converts the object to JSON
    @Override
    public String toString() {
        String text = "{\"racks\":[";
        if(racks.size() > 0) {
            for(int i = 0; i < racks.size() - 1; i++) {
                text += racks.get(i).toString() + ",";
            }
        }
        text += "]}";
        return text;
    }
}

