# Conversor de Monedas en Java 💱

Este proyecto es una aplicación de consola escrita en Java que permite convertir entre distintas monedas a través de un menú interactivo.

---

## ✨ Características

- Menú dinámico que muestra opciones de conversión entre monedas (por ejemplo: de USD a EUR).
- Opción para salir del programa.
- Entrada de usuario por teclado para seleccionar una conversión.
- Obtención del tipo de cambio desde un servicio externo usando una API.
- Conversión de cantidades con resultado redondeado.
- Compatible con UTF-8 para mostrar caracteres especiales correctamente.

---

## 🔐 API Key requerida

Para obtener los tipos de cambio en tiempo real, el programa requiere una **API Key** válida de  [exchangerate-api.com](https://www.exchangerate-api.com/) 

Debes crear un archivo de texto llamado `apikey.txt`  en la misma carpeta del programa, que contenga únicamente tu API Key en la primera línea. Por ejemplo:

`ad6d3c4b44b0adf2200ec86z`

Ojo esta **API Key** no es valida


Este archivo es leído automáticamente cada vez que hace las consultas, lo utiliza como input para que puedan realizarse exitosamente las consultas de tipo de cambio

---

## 🧱 Estructura del Proyecto

### `Main.java`
Punto de entrada del programa. Crea el menú, agrega las opciones de conversión y gestiona el ciclo principal de interacción con el usuario.

### `Menu.java`
Contiene la lógica para construir y mostrar el menú de opciones. Permite agregar nuevas conversiones y maneja la opción de salida. También se encarga de preguntar al usuario qué opción desea ejecutar.

### `Monedas.java`
Clase que contiene un `Map<String, String>` con nombres legibles de las monedas (por ejemplo: `"USD" → "Dólar estadounidense"`). Esto permite mostrar descripciones más amigables en el menú.

### `CurrencyConverter.java`
Clase encargada de:
- Leer la `apikey` desde el archivo.
- Hacer la solicitud HTTP a la API externa.
- Parsear el JSON recibido.
- Proveer el tipo de cambio correspondiente desde una moneda origen a una destino.

---

## ▶️ Cómo Ejecutar

1. Asegúrate de tener Java (JDK 8 o superior) instalado.
2. Crea un archivo llamado `apikey` con tu clave API.


