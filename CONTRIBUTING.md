# Guía de Contribución

Gracias por tu interés en contribuir a **java-poo-luigi2**

Este documento establece las pautas para contribuir al proyecto. Al participar, aceptas cumplir con nuestro Código de Conducta (si existiera) y seguir estas reglas para mantener el código limpio y consistente.

## ¿Cómo puedo contribuir?

### 1. Reportar Errores (Bugs)
Si encuentras un error, por favor abre un **Issue** en el repositorio describiendo:
- Pasos para reproducir el error.
- Comportamiento esperado vs. comportamiento real.
- Capturas de pantalla o logs si es posible.

### 2. Sugerir Mejoras
Si tienes una idea para una nueva funcionalidad:
- Abre un **Issue** con la etiqueta `enhancement`.
- Explica claramente por qué esta mejora sería útil.

### 3. Enviar Cambios (Pull Requests)
1.  **Fork** el repositorio.
2.  Crea una nueva rama para tu funcionalidad o corrección:
    ```bash
    git checkout -b feature/nueva-funcionalidad
    ```
    o
    ```bash
    git checkout -b fix/correccion-bug
    ```
3.  Realiza tus cambios siguiendo las **Normas de Estilo** (ver abajo).
4.  Haz commit de tus cambios con mensajes descriptivos:
    ```bash
    git commit -m "Agrega validación de entrada en ScannerUtils"
    ```
5.  Haz push a tu rama:
    ```bash
    git push origin feature/nueva-funcionalidad
    ```
6.  Abre un **Pull Request** (PR) hacia la rama `main` del repositorio original.

## Comandos Útiles
Aquí tienes una lista de comandos rápidos para trabajar con el proyecto desde la terminal:

| Acción | Comando |
| :--- | :--- |
| **Compilar** | `javac -d out -sourcepath src src/platzi/play/Main.java` |
| **Ejecutar** | `java -cp out platzi.play.Main` |
| **Limpiar** | `rm -rf out` (Linux/Mac) o `rd /s /q out` (Windows) |
| **Generar Javadoc** | `javadoc -d doc -sourcepath src -subpackages platzi.play` |

## Normas de Estilo de Código

Para mantener la consistencia del proyecto, por favor sigue estas reglas:

- **Idioma**: El código, comentarios y commits deben estar en **Español** (o Inglés si así se prefiere, pero mantén la consistencia con el código existente).
- **Nombres de Clases**: PascalCase (ej. `Pelicula`, `ScannerUtils`).
- **Nombres de Métodos y Variables**: camelCase (ej. `capturarTexto`, `nombrePelicula`).
- **Constantes**: UPPER_SNAKE_CASE (ej. `NOMBRE_PLATAFORMA`).
- **Indentación**: Usa 4 espacios (no tabulaciones).
- **Documentación**: Agrega Javadoc a las clases y métodos públicos nuevos.

## Mensajes de Commit

Utilizamos [Commits Convencionales](https://www.conventionalcommits.org/es/):

*   `feat`: Una nueva funcionalidad.
*   `fix`: Corrección de un bug.
*   `docs`: Cambios en la documentación.
*   `style`: Cambios que no afectan el significado del código (espacios, formato, etc).
*   `refactor`: Cambio de código que no corrige un bug ni añade una funcionalidad.
*   `test`: Añadir o corregir tests.

Ejemplo: `feat: agregar endpoint para buscar películas por idioma`

## Proceso de Revisión
Tu PR será revisado, es posible que te pidamos realizar algunos cambios antes de fusionarlo. ¡Sé paciente y receptivo al feedback!

### **Código de Conducta**

Se espera un trato respetuoso y profesional en todos los comentarios y discusiones del repositorio.

---

¡Gracias por ayudar a mejorar este proyecto!
**Luis Cacuango** - [luiscacuango2084@gmail.com](mailto:luiscacuango2084@gmail.com)
