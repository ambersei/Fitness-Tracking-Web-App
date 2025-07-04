# Fitness-Tracking-Web-App

A full-stack fitness tracking web application built with **Spring Boot (Java)** for the backend, **React** for the frontend, and **PostgreSQL** as the database. This project is designed as a production-ready portfolio piece to demonstrate full-stack development skills, RESTful API design, and responsive UI development.

## Built With
React
Spring Boot
PostgreSQL

## Features

- 🔐 **Client Authentication** – Secure login and personalized experience.
- 🏢 **Gym Location Browser** – View all locations, filter by status (home, visited, unvisited), and explore amenities.
- 🧑‍🏫 **Coach Profiles & Ratings** – View available coaches per location and read/write reviews with real-time rating updates.
- 🗓 **Class Schedules** – Browse group classes offered at each location.
- 📝 **Client Reviews** – Leave feedback on coaches, with rating logic influencing overall coach scores.
- 📊 **Responsive UI** – Card-based layout, scrollable sections, and conditional rendering for logged-in users.

# Tech Stack

| Layer        | Technology               |
|-------------|---------------------------|
| Frontend     | React, React Router DOM   |
| Backend      | Java, Spring Boot         |
| Database     | PostgreSQL                |
| Versioning   | Git + GitHub              |


## Project Structure (High-Level)
```
fitness-tracking-app/
├── backend/ # Spring Boot project
│ ├── controller/ # REST API controllers
│ ├── service/ # Business logic
│ ├── repository/ # JPA repositories
│ └── model/ # Domain models (Client, Coach, etc.)
├── frontend/ # React project
│ ├── pages/ # Route-based pages (Home, Locations, Login, etc.)
│ ├── components/ # Reusable components (Navbar, Cards, etc.)
│ └── App.js # App routing and state
└── README.md # You're reading it!
```

## Getting Started

### Prerequisites

- Java 17+
- Node.js 18+
- PostgreSQL
- Maven

### Backend Setup

```bash
cd backend/
./mvnw spring-boot:run
```
Frontend Setup
```bash
cd frontend/
npm install
npm start
```
Make sure the proxy is configured to connect frontend requests to localhost:8080

## Roadmap
- [x] Location + Coach + Class Models
- [x] Client Login
- [x] Review + Rating Flow
- [ ] Class Booking (Coming Soon)
- [ ] Coach Detail Page
- [ ] Admin Panel (Post-MVP)

## In Progress
This project is actively being developed and improved. Follow the Commits and Issues for updates.

## License
This project is licensed under the MIT License.


## Author
Built with ❤️ by Amber – aspiring full-stack developer.

[LinkedIn](https://www.linkedin.com/in/amber-hou/) • [GitHub](https://github.com/ambersei)
