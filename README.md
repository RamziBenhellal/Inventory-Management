# 📦 Inventory Management System (Spring Boot, MySQL, Docker)

Ein leichtgewichtiges, modular aufgebautes Inventory-Management-System zur Verwaltung von Produkten, Kategorien und Lagerbeständen.  
Das Projekt wurde mit **Java 17**, **Spring Boot 3**, **Spring Data JPA**, **Validation**, **Swagger** und **Docker Compose** entwickelt.

Dieses System eignet sich perfekt als Lernprojekt oder Portfolio-Projekt für Backend- und API-Entwicklung.

---

## 🚀 Features

- CRUD-Funktionen für Produkte
- Automatische Zuordnung oder Erstellung von Kategorien
- Anzeige von Produkten unter Mindestbestand (Low-Stock)
- Validierung aller Eingabedaten
- MySQL-Datenbank via Docker Compose
- API-Dokumentation mit Swagger UI
- Moderne Schichtenarchitektur (Controller → Service → DTO → Entity)
- Cross-Origin Unterstützung für Frontend-Integration

---

## 🛠️ Tech Stack

| Bereich      | Technologien |
|--------------|--------------|
| Sprache      | Java 17 |
| Framework    | Spring Boot 3 (Web, Data JPA, Validation) |
| Datenbank    | MySQL 8 (Docker) |
| Dokumentation | Swagger / springdoc-openapi |
| Tools        | Maven, Docker, Docker Compose |
| Build        | JAR Deployment |

---

## 📁 Projektstruktur

```
src/
 ├─ main/
 │   ├─ java/com/ramzi/inventorymanagement/
 │   │   ├─ controller/
 │   │   ├─ service/
 │   │   ├─ dto/
 │   │   ├─ entity/
 │   │   ├─ repository/
 │   │   └─ exception/
 │   └─ resources/
 │       ├─ application.yml
 │       └─ static/templates/etc.
 ├─ test/
Dockerfile
docker-compose.yml
HELP.md
README.md
```

---

## 🔌 API Endpoints

| Methode | Pfad | Beschreibung |
|--------|------|--------------|
| GET | `/api/products/` | Liste aller Produkte |
| GET | `/api/products/{id}` | Produkt nach ID abrufen |
| POST | `/api/products` | Neues Produkt anlegen |
| PUT | `/api/products/{id}` | Produkt aktualisieren |
| DELETE | `/api/products/{id}` | Produkt löschen |
| GET | `/api/products/low-stock` | Produkte unter Mindestbestand |

---

## 📘 Swagger UI

```
http://localhost:8080/swagger-ui/index.html
```

oder bei Docker:

```
http://localhost:8080/swagger-ui/index.html
```

---

## ▶️ Lokales Starten (ohne Docker)

```
mvn clean package -DskipTests
java -jar target/inventory-management-0.0.1-SNAPSHOT.jar
```

---

## 🐳 Start mit Docker Compose

```
docker compose up --build
```

---

## 🧪 Beispiel-Request (cURL)

```
curl -X POST http://localhost:8080/api/products   -H "Content-Type: application/json"   -d '{
      "name": "Laptop X",
      "sku": "LAP-001",
      "quantity": 5,
      "minStock": 2,
      "price": 999.99,
      "categoryName": "Elektronik"
  }'
```

---

## 👤 Autor

Mohammed Ramzi Ben Hellal
