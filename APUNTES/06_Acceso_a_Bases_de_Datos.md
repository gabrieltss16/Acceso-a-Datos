# Apuntes sobre Acceso a Bases de Datos

## Introducción
El acceso a bases de datos es un componente esencial en el desarrollo de aplicaciones. Permite a las aplicaciones leer, escribir y manipular datos almacenados en una base de datos.

## Tipos de Bases de Datos
1. **Relacionales**: Usan un modelo basado en tablas (ej. MySQL, PostgreSQL).
2. **NoSQL**: Se basan en otros modelos como documentos, grafos, etc. (ej. MongoDB, Cassandra).

## Conexión a Bases de Datos
Para acceder a una base de datos, primero se debe establecer una conexión. Esto puede hacerse mediante:
- **Drivers y librerías**: Como JDBC para Java o SQLAlchemy para Python.
- **ORM (Object-Relational Mapping)**: Herramientas que permiten interactuar con la base de datos usando objetos en lugar de SQL.

## Operaciones Comunes
- **CRUD**: Crear, Leer, Actualizar y Eliminar. Estas son las operaciones básicas realizadas en una base de datos.

### Consultas SQL
Las consultas SQL se utilizan para interactuar con bases de datos relacionales. Ejemplos:
- **SELECT**: Recuperar datos.
- **INSERT**: Agregar nuevos registros.
- **UPDATE**: Modificar registros existentes.
- **DELETE**: Eliminar registros.

## Seguridad
La seguridad en bases de datos es crucial. Debe incluir:
- **Autenticación y Autorización**: Asegurar que solo usuarios válidos puedan acceder y manipular los datos.
- **Encriptación**: Proteger datos sensibles tanto en tránsito como en reposo.

## Conclusión
El acceso a bases de datos permite la creación de aplicaciones dinámicas y efectivas. Entender los diferentes tipos, métodos de conexión y operaciones es fundamental para cualquier desarrollador.