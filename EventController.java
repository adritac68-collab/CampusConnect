package com.campusconnect;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
@RestController @RequestMapping("/api/events")
public class EventController {
 private final EventRepository events; private final RegistrationRepository regs;
 public EventController(EventRepository e,RegistrationRepository r){events=e;regs=r;}
 @GetMapping public List<Map<String,Object>> all(){return events.findAll().stream().sorted(Comparator.comparing(Event::getDate)).map(this::view).toList();}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Map<String,Object> create(@Valid @RequestBody Event e){e.setId(null);return view(events.save(e));}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){
  Event e=events.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Event not found"));
  regs.deleteAll(regs.findByEventIdOrderByRegisteredAtDesc(id));events.delete(e);
 }
 private Map<String,Object> view(Event e){Map<String,Object> m=new LinkedHashMap<>();m.put("id",e.getId());m.put("title",e.getTitle());m.put("club",e.getClub());m.put("date",e.getDate());m.put("time",e.getTime());m.put("venue",e.getVenue());m.put("description",e.getDescription());m.put("capacity",e.getCapacity());m.put("attendees",regs.countByEventId(e.getId()));return m;}
}