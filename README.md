# YapeTest

Este proyecto es una solucion de una prueba planteada por Yape.

## ¿Como se realiza la solucion del Test?

Se crea un proyecto de Android utilizando Jetpack Compose. Una vez finalizada la creación, se aplica Clean Architecture y MVVM con la finalidad de desacoplar la lógica de negocio de la vista y la infraestructura, garantizando así que se genere un código limpio, estructurado y legible.

Este proyecto también cuenta con pruebas unitarias que se enfocan en resolver la lógica de negocio en lugar de cumplir con la cobertura. En su interior se encuentran patrones de diseño y buenas prácticas.

Por último, se aplican buenas prácticas de código y principios para garantizar el proceso.


## ¿Que arquitecturas se utiliza?

A continuación, se presenta un diagrama que ilustra la estructura de Clean Architecture:

![Clean Architecture](https://mahedee.net/assets/images/posts/2021/clean.png)
**Nota:** Para este proyecto no se esta utilizando la capa de Application ni de Persistence.

Para implementar la arquitectura limpia en el proyecto, debemos crear dos módulos o capas adicionales: **Domain** e **Infrastructure**, además de renombrar la capa **App** como **Presentation**.
* **Presentation:** En esta capa se encuentra todo lo relacionado con la interfaz de usuario.
* **Domain:** Aquí se encuentra toda la lógica de negocio de la aplicación.
* **Infrastructure:** En esta capa se implementa la conexión a APIs o bases de datos para obtener los datos necesarios.

Además, se aplica la arquitectura de diseño **MVVM**, que nos ayuda a implementar la reactividad de una manera más sencilla.

![MVVM](https://www.adictosaltrabajo.com/wp-content/uploads/2020/06/MVVMPattern.png)

Internamente, se aplican diferentes patrones de diseño, los cuales se explican posteriormente.

## ¿Qué patrones de diseño utilizamos?

Los patrones de diseño se utilizan para resolver problemas en los cuales se necesita estandarizar una solución que ayude a disminuir la fricción en cuanto al entendimiento de la solución. En este caso, utilizamos:

-   **Repository pattern:** Este patrón nos ayuda a transportar la información desde la capa de infraestructura evitando el acoplamiento de capas.
  ![RepositoryPattern](https://miro.medium.com/max/981/1*5kNXJ7aFSGJvuh4r4egpTg.png)
* **Translate pattern:** Este patrón nos ayuda a transformar el objeto DTO recibido al consumir la API en un objeto de Dominio de manera sencilla.
* **DataBuilder pattern:** Este patrón nos ayuda a construir objetos con características especiales que se necesitan en las pruebas que se deseen realizar.
* **Dependency injection:** Este patrón nos ayuda a crear los objetos de una manera útil y escalable, permitiéndonos desacoplar completamente el dominio de las demás capas.


## ¿Qué bibliotecas se utilizaron en el proyecto?

Se utilizaron las siguientes bibliotecas para solucionar problemas comunes en el desarrollo, lo que facilita la implementación del proyecto:

-   **Hilt:** Biblioteca utilizada para la inyección de dependencias.
-   **Retrofit2:** Biblioteca utilizada para definir la estructura de las peticiones a las APIs.
-   **LiveData:** Biblioteca utilizada para crear valores reactivos.
-   **Mockito:** Biblioteca utilizada para crear datos falsos en las pruebas unitarias.

## Agregando Google Maps a la aplicación

Para mejorar la experiencia del usuario, se decidió implementar Google Maps en la aplicación. Esto permitirá que el usuario pueda visualizar las ubicaciones de los diferentes restaurantes en un mapa y así facilitar la selección de un restaurante cercano.

Para lograr esto, se utilizó la librería de Google Maps para Android, que ofrece una fácil integración y personalización del mapa. Además, se utilizó la API de Google Maps para obtener los datos necesarios para mostrar los marcadores de los restaurantes en el mapa.

Se aprovechó la arquitectura de la aplicación y se creó una nueva capa de `Map` en la capa de presentación. En esta capa, se implementaron las funciones necesarias para mostrar el mapa y los marcadores en la vista.

De esta manera, se logró una aplicación más completa y funcional para el usuario.

## Consideraciones adicionales

El repositorio es público, por lo que no es necesario manejar credenciales adicionales ni solicitar permisos al dueño del repositorio @felipevelasquez1717 para acceder a su contenido.

El proyecto tiene dos variantes de construcción: **PROD** y **MOCK**:

-   **PROD:** Contiene toda la configuración necesaria para realizar peticiones al servicio.
-   **MOCK:** Contiene información falsa desde la infraestructura.

# Ejecución del proyecto

Para ejecutar el proyecto, sigue estos pasos:

1.  Crea una carpeta en la que almacenarás el repositorio. En Windows, puedes utilizar el comando `md projects`, mientras que en Linux o Mac, puedes utilizar el comando `mkdir projects`.
2.  Accede a la carpeta que acabas de crear mediante el comando `cd projects`.
3.  Clona el repositorio con el comando `git clone https://github.com/FelipeVelasquez1802/RecipeBook.git`. Ten en cuenta que debes tener Git instalado en tu equipo para poder realizar este paso.
4.  Abre el proyecto con tu IDE de confianza y ejecútalo.
