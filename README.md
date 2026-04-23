# 🏢 SmartCampusAPI

SmartCampusAPI is a RESTful web service built using Java JAX-RS to manage rooms and environmental sensors in a smart campus environment. The system supports room and sensor management, real-time sensor readings, filtering, structured error handling, and logging. Data is stored using an in-memory data store.

---

## 🚀 Features

* Room management (Create, Read, Delete)
* Sensor management with validation
* Sensor readings (sub-resource)
* Filtering sensors by type
* Structured error handling (409, 422, 403, 500)
* Logging of HTTP requests and responses
* In-memory data storage

---

## ℹ️ API Overview

The API follows RESTful principles and is structured around:

* **Rooms** → Manage campus locations
* **Sensors** → Linked to rooms, support filtering
* **Sensor Readings** → Sub-resource for time-based data

---

## 🌐 Base URL

```
http://localhost:8080/SmartCampusAPI/api/v1
```

---

## 📌 API Endpoints + curl Examples

---

### 🔹 Discovery

```bash
curl http://localhost:8080/SmartCampusAPI/api/v1
```

---

### 🔹 Create Room

```bash
curl -X POST http://localhost:8080/SmartCampusAPI/api/v1/rooms \
-H "Content-Type: application/json" \
-d '{"id":"R1","name":"Lab 1","capacity":40}'
```

---

### 🔹 Get All Rooms

```bash
curl http://localhost:8080/SmartCampusAPI/api/v1/rooms
```

---

### 🔹 Get Room by ID

```bash
curl http://localhost:8080/SmartCampusAPI/api/v1/rooms/R1
```

---

### 🔹 Delete Room

```bash
curl -X DELETE http://localhost:8080/SmartCampusAPI/api/v1/rooms/R1
```

---

### 🔹 Create Sensor

```bash
curl -X POST http://localhost:8080/SmartCampusAPI/api/v1/sensors \
-H "Content-Type: application/json" \
-d '{"id":"S1","type":"CO2","status":"ACTIVE","roomId":"R1"}'
```

---

### 🔹 Get All Sensors

```bash
curl http://localhost:8080/SmartCampusAPI/api/v1/sensors
```

---

### 🔹 Filter Sensors

```bash
curl "http://localhost:8080/SmartCampusAPI/api/v1/sensors?type=CO2"
```

---

### 🔹 Add Sensor Reading

```bash
curl -X POST http://localhost:8080/SmartCampusAPI/api/v1/sensors/S1/readings \
-H "Content-Type: application/json" \
-d '{"id":"READ1","timestamp":1710000000,"value":55.5}'
```

---

### 🔹 Get Sensor Readings

```bash
curl http://localhost:8080/SmartCampusAPI/api/v1/sensors/S1/readings
```

---

## ⚠️ Error Handling

| Code | Description             |
| ---- | ----------------------- |
| 404  | Resource not found      |
| 409  | Room has active sensors |
| 422  | Room does not exist     |
| 403  | Sensor in maintenance   |
| 500  | Internal server error   |


---

## ▶️ How to Run

1. Clone repository
2. Open in NetBeans
3. Configure Apache Tomcat
4. Run:

   ```
   mvn clean install
   ```
5. Deploy and access API

---

## 👤 Author

Student: K.M.C.I Kariyawasam | 20231470 / w2120235

Module: 5COSC022W Client-Server Architectures
