# Spring Boot Security – JDBC Authentication & Authorization  

## 📌 Overview  
This branch demonstrates how to secure a Spring Boot REST API using **Spring Security** with **JDBC authentication and authorization**.  
Instead of in-memory users, authentication is performed against a **database**.  

---

## ⚙️ Features  
- Configured **Spring Security** with JDBC authentication.  
- Users and roles stored in relational database tables (`users`, `authorities`).  
- Role-based access control applied to REST endpoints.  
- Secured endpoints with **Basic Authentication**.  
- CRUD endpoints for `Instructor` entity.  

---

## 🗄️ Database Schema  

### Users Table  
```sql
CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    enabled  TINYINT NOT NULL
);
CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT authorities_idx_1 UNIQUE (username, authority),
    CONSTRAINT authorities_ibfk_1 FOREIGN KEY (username)
        REFERENCES users(username)
);
INSERT INTO users (username,password,enabled)
VALUES 
('abdelrhman','{noop}abdelrhman',1),
('ali','{noop}ali',1),
('khaled','{noop}khaled',1)

INSERT INTO authorities (username,authority)
VALUES 
('abdelrhman','ROLE_EMPLOYEE'),
('ali','ROLE_MANAGER'),
('khaled','ROLE_ADMIN')
