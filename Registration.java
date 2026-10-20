package com.campusconnect;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"event_id","email"}))
public class Registration {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private Event event;
 @NotBlank private String studentName;
 @Email @NotBlank private String email;
 private LocalDateTime registeredAt=LocalDateTime.now();
 public Registration() {}
 public Long getId(){return id;} public Event getEvent(){return event;} public void setEvent(Event v){event=v;}
 public String getStudentName(){return studentName;} public void setStudentName(String v){studentName=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public LocalDateTime getRegisteredAt(){return registeredAt;}
}