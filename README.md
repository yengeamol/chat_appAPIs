Chat App API

Welcome to the Chat App API! This project is a backend implementation of a real-time chat application.
It enables users to create and join chat rooms, exchange messages in real-time, and retrieve chat histories, 
all powered by modern technologies such as Spring Boot, Hibernate, JPA, MongoDB, WebSocket, and STOMP.

Features :-

1) Join Existing Room: Users can join an existing chat room by entering a valid Room ID.

2) Create New Room: Users can create a new chat room with a system-generated unique Room ID.

3) Message Persistence: All messages within a room are stored in MongoDB for persistent storage.

4) View Chat History: When users join a room, they can view previously saved messages for that room.

5) Real-Time Messaging: Real-time messaging updates are provided for all users in the room.

Technologies Used:-

1) Spring Boot: Backend framework for building Java-based REST APIs.

2) Hibernate & JPA: For managing relational data and ORM capabilities.

3) MongoDB: NoSQL database for storing chat messages.

4) WebSocket: For enabling real-time, bidirectional communication between users.

5) STOMP: Messaging protocol used over WebSocket.

6) REST API: For managing room creation and joining functionality.

7) Maven: Dependency management and project build tool.

Prerequisites:-

1) Java 17 or later

2) Maven 3.6+

3) MongoDB server installed and running


Setup Instructions

Clone the Repository:

git clone https://github.com/your-username/chat-app-api.git
cd chat-app-api

Build the Project:

mvn clean install

Configure MongoDB:
Update the MongoDB connection details in application.properties:

spring.data.mongodb.uri=mongodb://localhost:27017/chatapp

Run the Application:

mvn spring-boot:run

Access the API:
The API will be running at http://localhost:8080.

API Endpoints

Room Management

Create Room:

Endpoint: POST /rooms

Description: Creates a new chat room and returns the unique Room ID.

Join Room:

Endpoint: GET /rooms/{roomId}

Description: Allows users to join an existing room by Room ID.

Messaging

Send Message:

Endpoint: POST /messages

Description: Sends a new message to a specific room.

Retrieve Messages:

Endpoint: GET /messages/{roomId}

Description: Retrieves all messages for the specified room.

WebSocket Configuration

WebSocket Endpoint: /ws

STOMP Topics:

/topic/rooms/{roomId}: Subscribes users to receive real-time messages for a specific room.

/app/chat/{roomId}: Sends messages to the specific room.

How It Works

Users create or join chat rooms using the REST API.

Messages sent within a room are handled by WebSocket and broadcast to all connected users in real time.

All messages are stored in MongoDB for persistence.

When a user joins a room, previously stored messages for that room are fetched and displayed.


Thank you for exploring the Chat App API! We hope this project helps you understand and implement real-time communication systems effectively.

