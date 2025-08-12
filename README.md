# NatWest Probe
A simple Spring Boot REST API to control a probe on a 5x5 grid.

The application will start at: http://localhost:8080

API Endpoints
1. Send commands to the probe
POST /api/probe/commands

Request
Content-Type: application/json

Body: a string of commands

F = Move forward

B = Move backward

L = Turn left

R = Turn right

Example:
POST "http://localhost:8080/api/probe/commands"
     "Content-Type: application/json"
     "FFRBL"
Response
200 OK — Commands executed, no content returned.

2. Get current probe state
GET /api/probe/state

"http://localhost:8080/api/probe/state"
Example Response
Position: (2, 3), Direction: NORTH

Example Usage

# Move forward twice, turn right, move backward, turn left
POST "http://localhost:8080/api/probe/commands"
     "Content-Type: application/json"
     "FFRBL"

Project Structure

src/main/java/com/example/probe/
  ├── ProbeApplication.java       # Entry point
  ├── controller/ProbeController  # API endpoints
  ├── service/ProbeService        # Core movement logic
  └── model/                      # Domain models (Point, Grid, Direction)
