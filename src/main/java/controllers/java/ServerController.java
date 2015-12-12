package hpapi.controllers;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hpapi.models.*;
import hpapi.retrieval.*;
//import hpapi.models;
//import hpapi.retrieval;
@RestController
public class ServerController {

  @RequestMapping(value="/server", method=RequestMethod.GET)
  public String server(@RequestParam(value="name", defaultValue="test") String name) {
    DataRetriever retriever = XMLRetriever.getInstance();
    return "test";
  }
}

