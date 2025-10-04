# ED2025
Estructuras de Datos 2025

## Descripción
Proyecto de estudio de Estructuras de Datos básicas en Java, incluyendo implementaciones de:
- Lista Enlazada Simple
- Pila (Stack)
- Cola (Queue)

## Estructura del Proyecto
```
ED2025/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── ed2025/
│   │           ├── Main.java      # Clase principal
│   │           ├── Lista.java     # Implementación de Lista Enlazada
│   │           ├── Pila.java      # Implementación de Pila
│   │           └── Cola.java      # Implementación de Cola
│   └── test/
│       └── java/
│           └── ed2025/
│               ├── ListaTest.java # Pruebas de Lista
│               ├── PilaTest.java  # Pruebas de Pila
│               └── ColaTest.java  # Pruebas de Cola
└── README.md
```

## Requisitos
- Java 11 o superior
- JDK instalado y configurado

## Compilación

Para compilar el proyecto:

```bash
# Compilar las clases principales
javac -d bin src/main/java/ed2025/*.java

# Compilar las clases de prueba
javac -cp bin -d bin src/test/java/ed2025/*.java
```

## Ejecución

### Ejecutar el programa principal:
```bash
java -cp bin ed2025.Main
```

### Ejecutar las pruebas:
```bash
# Pruebas de Lista
java -cp bin ed2025.ListaTest

# Pruebas de Pila
java -cp bin ed2025.PilaTest

# Pruebas de Cola
java -cp bin ed2025.ColaTest
```

## Estructuras de Datos Implementadas

### Lista Enlazada Simple
- `agregar(int dato)`: Agrega un elemento al final
- `eliminar(int dato)`: Elimina un elemento específico
- `buscar(int dato)`: Busca un elemento en la lista
- `mostrar()`: Muestra todos los elementos
- `getTamano()`: Retorna el número de elementos
- `estaVacia()`: Verifica si la lista está vacía

### Pila (Stack)
- `apilar(int elemento)`: Agrega un elemento al tope
- `desapilar()`: Remueve y retorna el elemento del tope
- `verTope()`: Retorna el elemento del tope sin removerlo
- `mostrar()`: Muestra todos los elementos
- `getTamano()`: Retorna el número de elementos
- `estaVacia()`: Verifica si la pila está vacía

### Cola (Queue)
- `encolar(int elemento)`: Agrega un elemento al final
- `desencolar()`: Remueve y retorna el elemento del frente
- `verFrente()`: Retorna el elemento del frente sin removerlo
- `mostrar()`: Muestra todos los elementos
- `getTamano()`: Retorna el número de elementos
- `estaVacia()`: Verifica si la cola está vacía
