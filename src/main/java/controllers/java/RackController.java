package hpapi.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import hpapi.models.*;
import hpapi.retrieval.*;

@RestController
public class RackController {
  @RequestMapping(value="/racks", method=RequestMethod.GET)
  public ResponseEntity<String> racks() {
    DataRetriever retriever = XMLRetriever.getInstance();
    return new ResponseEntity<>(retriever.getAllRacks().toString(),HttpStatus.OK);
  }

  @RequestMapping(value="/rack/{id}", method=RequestMethod.GET)
  public ResponseEntity<String> getRack(@PathVariable("id") int id) {
    DataRetriever retriever = XMLRetriever.getInstance();
    Rack rack = retriever.getRackById(id);
    if(rack != null) {
      return new ResponseEntity<>(rack.toString(), HttpStatus.OK);
    }
    return new ResponseEntity<>("{\"message\":\"rack not found.\"}", HttpStatus.NOT_FOUND);
  }
  @RequestMapping(value="/rack/{id}/remaining", method=RequestMethod.GET)
  public ResponseEntity<String> getRackRemaining(@PathVariable("id") int id) {
    DataRetriever retriever = XMLRetriever.getInstance();
    Rack rack = retriever.getRackById(id);
    if(rack != null) {
      int remaining = rack.getEmptySpace();
      String text = remaining + " units remaining in rack";
      return new ResponseEntity<>("{\"message\":\"" + text + "\"}", HttpStatus.OK);
    }
    return new ResponseEntity<>("{\"message\":\"rack not found.\"}", HttpStatus.NOT_FOUND);
  }
  @RequestMapping(value="/rack/{id}/name", method=RequestMethod.GET)
  public ResponseEntity<String> getRackName(@PathVariable("id") int id) {
    DataRetriever retriever = XMLRetriever.getInstance();
    Rack rack = retriever.getRackById(id);
    if(rack != null) {
      String text = rack.getName();
      return new ResponseEntity<>("{\"message\":\"" + text + "\"}", HttpStatus.OK);
    }
    return new ResponseEntity<>("{\"message\":\"rack not found.\"}", HttpStatus.NOT_FOUND);
  }
}
