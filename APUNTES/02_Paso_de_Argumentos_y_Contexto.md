# Paso de Argumentos y Contexto

## 1. Introducción
El paso de argumentos y el contexto son conceptos fundamentales en programación que permiten a las funciones recibir datos y ejecutarse en el contexto adecuado.

## 2. Tipos de Paso de Argumentos
### 2.1. Paso por Valor
- En este método, se pasa una copia del valor a la función.
- Cambios en el parámetro dentro de la función no afectan el argumento original.
- Ejemplo en C/C++:
  ```c
  void funcion(int x) {
      x = 10;
  }
  ```

### 2.2. Paso por Referencia
- Se pasa una referencia al argumento original.
- Cambios en el parámetro dentro de la función afectan el argumento original.
- Ejemplo en C++:
  ```c++
  void funcion(int &x) {
      x = 10;
  }
  ```

### 2.3. Paso por Valor vs. Referencia
- **Ventajas del Paso por Valor:**
  - Seguridad: el argumento original no se modifica.
- **Ventajas del Paso por Referencia:**
  - Eficiencia: no se copian grandes estructuras de datos.

## 3. Contexto
### 3.1. Contexto de Ejecución
- El contexto se refiere a las variables y objetos accesibles en un bloque de código determinado.
- En JavaScript, por ejemplo, el contexto se determina por cómo se llama a una función.

### 3.2. Manejo de Contexto
- Usar el método `call()`, `apply()` o `bind()` en JavaScript permite establecer el contexto de la función.
- Ejemplo:
  ```javascript
  function saludar() {
      console.log(`Hola, ${this.nombre}`);
  }
  const obj = { nombre: 'Juan' };
  saludar.call(obj); // Hola, Juan
  ```

## 4. Conclusión
Comprender el paso de argumentos y el contexto es esencial para escribir funciones efectivas y manejar adecuadamente datos en programación.