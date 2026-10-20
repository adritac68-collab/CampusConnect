# CampusConnect — Campus Event & Club Management System

A full-stack Java portfolio project for discovering campus events and registering students.

## Features
- List and search campus events
- Create and delete events
- Register students by name and email
- Prevent duplicate registrations and full-event registrations
- Attendee counts and capacity
- REST API + database-backed storage

## Stack
- Frontend: HTML, CSS, JavaScript
- Backend: Java 17, Spring Boot, REST API
- Database: H2 (local file database)

## Run locally
1. Install Java 17+ and Maven 3.8+.
2. Extract the ZIP and open a terminal inside `CampusConnect-FullStack`.
3. Run `mvn spring-boot:run`.
4. Visit http://localhost:8080

## API
- `GET /api/events` — list events
- `POST /api/events` — create event
- `DELETE /api/events/{id}` — delete event
- `POST /api/events/{id}/registrations` — register a student
- `GET /api/events/{id}/registrations` — view registrations

Example event JSON:
```json
{"title":"AI Study Jam","club":"AI Club","date":"2026-11-15","time":"15:00","venue":"Lab 2","description":"A beginner-friendly session","capacity":40}
```

## Project structure
- `src/main/java/com/campusconnect/` — Java backend
- `src/main/resources/static/` — frontend files
- `src/main/resources/application.properties` — database settings

This is a learning/demo project. Login, role-based permissions, email notifications, and cloud deployment are not included yet.
