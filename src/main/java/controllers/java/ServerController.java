package hpapi.controllers;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import hpapi.models.*;
import hpapi.retrieval.*;
//import hpapi.models;
//import hpapi.retrieval;
@RestController
public class ServerController {

  // Request mapping that returns a JSON server object on get /server/serverid
  @RequestMapping(value="/server/{id}", method=RequestMethod.GET)
  public ResponseEntity<String> getServer(@PathVariable("id") String id) {
    DataRetriever retriever = XMLRetriever.getInstance();
    Server server = retriever.getServerById(id);
    if(server != null) {
      return new ResponseEntity<>(server.toString(), HttpStatus.OK);
    }
    return new ResponseEntity<>("{\"message\":\"server not found.\"}", HttpStatus.NOT_FOUND);
  }
  // Request mapping that returns just the servers name on get /server/serverid/name
  @RequestMapping(value="/server/{id}/name", method=RequestMethod.GET)
  public ResponseEntity<String> getServerName(@PathVariable("id") String id) {
    DataRetriever retriever = XMLRetriever.getInstance();
    Server server = retriever.getServerById(id);
    if(server != null) {
      return new ResponseEntity<>("{\"name\":\"" + server.getName() + "\"}", HttpStatus.OK);
    }
    return new ResponseEntity<>("{\"message\":\"server not found.\"}", HttpStatus.NOT_FOUND);
  }
}

