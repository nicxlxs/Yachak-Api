# **Yachak Backend**

Backend del proyecto **Yachak**, desarrollado en **Spring Boot** y utilizando **Cassandra** como base de datos. Este backend expone una serie de endpoints para gestionar usuarios, miembros de grupo y relaciones de seguimiento, con soporte para autenticación basada en **JWT**.

---

## **Características**
- **Gestión de Usuarios:** Crear, obtener, actualizar y eliminar usuarios.
- **Gestión de Miembros de Grupo:** Crear y eliminar miembros de grupos con roles.
- **Relaciones de Seguimiento (Follows):** Crear y eliminar relaciones de seguimiento entre usuarios.
- **Autenticación JWT:** Seguridad para proteger los endpoints mediante tokens.

---

## **Tecnologías**
- **Lenguaje:** Java 17+
- **Framework:** Spring Boot
- **Base de Datos:** Apache Cassandra
---

## **Requisitos**
- **Java 17 o superior**
- **Maven**
- **Docker** (para Cassandra)

---

## **Instalación**

### **1. Clonar el Repositorio**
```bash
git clone https://github.com/tu-repositorio/yachak-backend.git
cd yachak-backend
