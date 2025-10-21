# Wizards Profile API

This is a Spring Boot REST API project built for the **Backend Wizards** task.  
It exposes a simple `/api/profile` endpoint that returns your personal profile data in JSON format.

---

## 🚀 Features
- Built with **Java 17**
- Uses **Spring Boot**
- Deployed on **Heroku**
- Returns JSON data containing:
  - `status`
  - `user`
  - `timestamp`
  - `fact` (random cat fact)

---

## 📡 API Endpoint

**GET** `/api/profile`

### Example Response
```json
{
  "status": "success",
  "user": {
    "name": "Yusuf Nehemiah",
    "email": "yusufnehemiah11@gmail.com",
    "github": "https://github.com/Yusuf1186"
  },
  "timestamp": "2025-10-21T09:15:32Z",
  "fact": "Cats can rotate their ears 180 degrees."
}
