# Sistema de Gestión de Contenidos (java-poo-luigi2)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)

Bienvenido al proyecto **java-poo-luigi2**. Este es un sistema de gestión de contenidos multimedia (películas y documentales) desarrollado en Java.

## Versión
1.0.0

## Descripción
La aplicación permite administrar una plataforma de streaming desde la consola, ofreciendo funcionalidades para gestionar el catálogo de contenidos y realizar búsquedas avanzadas.

## Funcionalidades Principales
- **Gestión de Contenido**: Agregar y eliminar películas y documentales.
- **Visualización**: Mostrar todo el catálogo o resúmenes.
- **Búsqueda Avanzada**: Filtrar por título, género, idioma, calidad y tipo de contenido.
- **Estadísticas y Rankings**: Ver contenidos populares, más vistos, y filtrar por duración (más larga/corta).
- **Reproducción**: Simulación de reproducción de contenido.

## Estructura del Proyecto
El código fuente se encuentra organizado de manera modular bajo el paquete `src/platzi/play`. A continuación se detalla la jerarquía de archivos:
```bash
src/platzi/play
├── contenido               # Modelos de dominio
│   ├── Contenido.java      # Clase base abstracta
│   ├── Documental.java     # Subclase para documentales
│   ├── Pelicula.java       # Subclase para películas
│   └── ResumenContenido.java
├── excepcion               # Manejo de errores
│   └── PeliculaExistenteException.java
├── plataforma              # Lógica de negocio y tipos
│   ├── Calidad.java        # Enum de calidades de video
│   ├── Genero.java         # Enum de géneros
│   ├── Idioma.java         # Enum de idiomas
│   ├── Plataforma.java     # Clase principal de gestión
│   └── Usuario.java        # Entidad de usuario
├── util                    # Utilidades transversales
│   ├── FileUtils.java      # Manejo de archivos
│   └── ScannerUtils.java   # Entrada de datos por consola
└── Main.java               # Punto de entrada (Entry Point)
```

## Dependencias Clave
- **Lenguaje**: Java (JDK 25 compatible con versiones anteriores).
- **IDE**: IntelliJ IDEA.
- **Control de Versiones**: Git.
- **Librerías**: `java.util`, `java.io` (Estándar).
## Buenas Prácticas Implementadas
- **Programación Orientada a Objetos (POO)**: Uso extensivo de herencia (`Pelicula` y `Documental` heredan de `Contenido`), polimorfismo y encapsulamiento.
- **Manejo de Excepciones**: Implementación de excepciones personalizadas (`PeliculaExistenteException`) para el control de errores de negocio.
- **Separación de Responsabilidades**:
    - `ScannerUtils` para la interacción con el usuario.
    - `FileUtils` para la persistencia de datos.
    - `Plataforma` como clase gestora de la lógica.
- **Uso de Enums**: Para definir tipos restringidos como `Genero`, `Idioma` y `Calidad`, mejorando la seguridad de tipos.
- **Streams y Lambdas**: Uso de la API de Streams de Java para filtrar y procesar colecciones de manera funcional.

## Módulos y Cobertura
El proyecto consta de un único módulo principal: `java-poo-luigi2`.
La cobertura de funcionalidades abarca desde la creación y gestión de entidades hasta la interacción por consola, cubriendo los casos de uso principales de un sistema ABM (Alta, Baja, Modificación) con búsquedas.

| Módulo | Descripción | Cobertura Funcional |
| :--- | :--- | :--- |
| `java-poo-luigi2` | Núcleo de la aplicación | ✅ **Gestión de Entidades**: Creación y modificación de Películas y Documentales.<br>✅ **Interacción**: Interfaz de línea de comandos (CLI) robusta.<br>✅ **Búsqueda**: Filtros por múltiples criterios (Género, Idioma, etc.).<br>✅ **Persistencia**: Lectura y carga de datos desde archivos. |
| `contenido` | Modelo de Datos | Definición de entidades `Pelicula`, `Documental` y atributos base. |
| `plataforma` | Lógica de Negocio | Gestión del catálogo, búsquedas, filtros y rankings. |
| `util` | Utilidades | Manejo de entrada/salida (Archivos y Consola). |
| `excepcion` | Manejo de Errores | Excepciones personalizadas del dominio. |

## Requisitos del Sistema
Antes de comenzar, asegúrate de tener instalado:
- **Sistema Operativo**: Windows, Linux o macOS.
- **Java Runtime Environment (JRE)** instalado y configurado en el PATH.
- **Java Development Kit (JDK)**: Versión 17 o superior recomendada.
- **IDE Recomendado**: IntelliJ IDEA, Eclipse o NetBeans para facilitar la edición y ejecución.
- **Git**: Para clonar el repositorio.

## Instalación y Configuración
Sigue estos pasos para configurar el proyecto en tu entorno local:
1.  **Clonar el repositorio**:
    ```bash
    git clone https://github.com/luiscacuango2/java-poo-luigi2.git
    cd java-poo-luigi2
    ```
2.  **Compilar el código**:
    Asegúrate de tener el JDK configurado. Desde la raíz del proyecto:
    ```bash
    javac -d out src/platzi/play/*.java src/platzi/play/**/*.java
    ```
3.  **Verificar archivo de datos**:
    El sistema busca un archivo `contenido.txt` en la raíz del proyecto para cargar la base de datos inicial. Puedes crear uno con datos de prueba:
    ```bash
    echo "PELICULA|Titanic|195|DRAMA|INGLES|FULL_HD|4.8|1997-12-19" > contenido.txt
    ```

## Cómo ejecutar
Ejecuta la clase `platzi.play.Main` para iniciar la aplicación. Sigue las instrucciones en la consola para navegar por el menú.
Una vez compilado, puedes ejecutar la aplicación desde la terminal:
     ```bash
     java -cp out platzi.play.Main
     ```
O si prefieres usar tu IDE:
1.  Abre el proyecto en IntelliJ IDEA.
2.  Busca la clase `src/platzi/play/Main.java`.
3.  Haz clic derecho y selecciona **Run 'Main.main()'**.

## Contribución
¡Las contribuciones son bienvenidas! Por favor, lee nuestro archivo [CONTRIBUTING.md](CONTRIBUTING.md) para conocer los detalles sobre nuestro código de conducta y el proceso para enviarnos pull requests.

## Autores ✒️
* **Luis Cacuango** - *Trabajo Inicial y Documentación* - [luiscacuango2](https://github.com/luiscacuango2)

## Agradecimientos
* A **Platzi** por el curso de Java SE Orientado a Objetos que sirvió de inspiración para la estructura del paquete `Luigi.play`.
* A la comunidad de código abierto por las herramientas facilitadas.

## Licencia
Este proyecto es de uso educativo y está bajo la Licencia MIT - mira el archivo [LICENSE](LICENSE) para más detalles.
