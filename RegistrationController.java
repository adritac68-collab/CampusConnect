package com.campusconnect;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
@RestController @RequestMapping("/api/events/{eventId}/registrations")
public class RegistrationController {
 private final EventRepository events; private final RegistrationRepository regs;
 public RegistrationController(EventRepository e,RegistrationRepository r){events=e;regs=r;}
 public record Request(@NotBlank String studentName,@Email @NotBlank String email){}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Map<String,Object> register(@PathVariable Long eventId,@Valid @RequestBody Request req){
  Event e=events.findById(eventId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Event not found"));
  String email=req.email().trim().toLowerCase();
  if(regs.existsByEventIdAndEmailIgnoreCase(eventId,email))throw new ResponseStatusException(HttpStatus.CONFLICT,"This email is already registered.");
  if(regs.countByEventId(eventId)>=e.getCapacity())throw new ResponseStatusException(HttpStatus.CONFLICT,"This event is full.");
  Registration r=new Registration();r.setEvent(e);r.setStudentName(req.studentName().trim());r.setEmail(email);r=regs.save(r);
  return Map.of("id",r.getId(),"studentName",r.getStudentName(),"email",r.getEmail(),"eventId",eventId);
 }
 @GetMapping public List<Map<String,Object>> list(@PathVariable Long eventId){
  if(!events.existsById(eventId))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Event not found");
  return regs.findByEventIdOrderByRegisteredAtDesc(eventId).stream().map(r->Map.<String,Object>of("id",r.getId(),"studentName",r.getStudentName(),"email",r.getEmail(),"registeredAt",r.getRegisteredAt())).toList();
 }
}