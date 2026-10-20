package com.campusconnect;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
@Entity
public class Event {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Size(max=100) private String title;
 @NotBlank @Size(max=80) private String club;
 @NotNull private LocalDate date;
 @NotBlank private String time;
 @NotBlank @Size(max=120) private String venue;
 @NotBlank @Size(max=1000) private String description;
 @Min(1) @Max(10000) private int capacity;
 public Event() {}
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public String getClub(){return club;} public void setClub(String v){club=v;}
 public LocalDate getDate(){return date;} public void setDate(LocalDate v){date=v;}
 public String getTime(){return time;} public void setTime(String v){time=v;}
 public String getVenue(){return venue;} public void setVenue(String v){venue=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public int getCapacity(){return capacity;} public void setCapacity(int v){capacity=v;}
}