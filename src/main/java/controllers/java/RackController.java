package hpapi.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import hpapi.models.*;
import hpapi.retrieval.*;


// Request mapping to get all racks on the server on get /racks
@RestController
public class RackController {
  @RequestMapping(value="/racks", method=RequestMethod.GET)
  public ResponseEntity<String> racks() {
    DataRetriever retriever = XMLRetriever.getInstance();
    return new ResponseEntity<>(retriever.getAllRacks().toString(),HttpStatus.OK);
  }

// Request mapping to get the JSON rack object on get /rack/rackid
  @RequestMapping(value="/rack/{id}", method=RequestMethod.GET)
  public ResponseEntity<String> getRack(@PathVariable("id") String id) {
    DataRetriever retriever = XMLRetriever.getInstance();
    Rack rack = retriever.getRackById(id);
    if(rack != null) {
      return new ResponseEntity<>(rack.toString(), HttpStatus.OK);
    }
    return new ResponseEntity<>("{\"message\":\"rack not found.\"}", HttpStatus.NOT_FOUND);
  }
// Request mapping to get the remaining number of slots on get /rack/rackid/remaining
  @RequestMapping(value="/rack/{id}/remaining", method=RequestMethod.GET)
  public ResponseEntity<String> getRackRemaining(@PathVariable("id") String id) {
    DataRetriever retriever = XMLRetriever.getInstance();
    Rack rack = retriever.getRackById(id);
    if(rack != null) {
      int remaining = rack.getEmptySpace();
      return new ResponseEntity<>("{\"remaining\":" + remaining + "}", HttpStatus.OK);
    }
    return new ResponseEntity<>("{\"message\":\"rack not found.\"}", HttpStatus.NOT_FOUND);
  }
//Request mapping to get the name of the rack on get /rack/rackid/name
  @RequestMapping(value="/rack/{id}/name", method=RequestMethod.GET)
  public ResponseEntity<String> getRackName(@PathVariable("id") String id) {
    DataRetriever retriever = XMLRetriever.getInstance();
    Rack rack = retriever.getRackById(id);
    if(rack != null) {
      String text = rack.getName();
      return new ResponseEntity<>("{\"name\":\"" + text + "\"}", HttpStatus.OK);
    }
    return new ResponseEntity<>("{\"message\":\"rack not found.\"}", HttpStatus.NOT_FOUND);
  }
}
