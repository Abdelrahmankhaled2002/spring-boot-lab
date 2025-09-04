## ⚙️ Features  
- Configured **Spring Security** with `InMemoryUserDetailsManager`.  
- Defined multiple users with roles: `EMPLOYEE`, `MANAGER`, `ADMIN`.  
- Secured REST APIs with **role-based authorization**.  
- Used **Basic Authentication** for testing with Postman / curl.  
- Example CRUD endpoints for `Instructor` entity.  

---

## 👤 Users and Roles  
| Username | Password | Roles                          |
|----------|----------|--------------------------------|
| `mohamed` | `mohamed` | `EMPLOYEE`                    |
| `ahmed`   | `ahmed`   | `EMPLOYEE`, `MANAGER`         |
| `shadi`   | `shadi`   | `EMPLOYEE`, `MANAGER`, `ADMIN` |

---

## 🔐 API Security Rules  
| HTTP Method | Endpoint               | Required Role |
|-------------|------------------------|---------------|
| GET         | `/api/instructors`     | EMPLOYEE      |
| GET         | `/api/instructors/{id}`| EMPLOYEE      |
| POST        | `/api/instructors`     | MANAGER       |
| PUT         | `/api/instructors`     | MANAGER       |
| PATCH       | `/api/instructors/{id}`| MANAGER       |
| DELETE      | `/api/instructors/{id}`| ADMIN         |

---

## 🚀 How to Run  
1. Clone the repository and switch to this branch:  
   ```bash
   git clone <your-repo-url>
   cd <your-project-folder>
   git checkout <branch-name>
