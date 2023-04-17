# Aplicación Móvil Pragma

La aplicación mostrará una lista de gatos en una pantalla principal utilizando la nueva tecnología de Compose,
la cual nos permitirá crear la interfaz de usuario de forma declarativa.

Para la arquitectura, se uso el patrón MVVM (Model-View-ViewModel) en el que se separarán las responsabilidades de la siguiente manera:

**Model:** La capa de modelo es responsable de acceder a los datos y proporcionarlos a la capa de ViewModel. Esta capa suele incluir una capa de datos que se comunica con una API remota o una base de datos local. Los datos se representan mediante clases Kotlin que contienen las propiedades necesarias para la aplicación. También se puede utilizar un repositorio para abstraer la lógica de acceso a los datos.

**ViewModel:** La capa de ViewModel es responsable de proporcionar los datos al componente de vista (View) y de manejar la lógica de negocio de la aplicación. El ViewModel contiene métodos que se comunican con la capa de modelo para recuperar y procesar los datos necesarios para la vista. Los objetos de ViewModel pueden ser reutilizados en diferentes vistas, lo que facilita la reutilización de código.

**View:** La capa de vista es responsable de mostrar los datos al usuario y de recibir sus interacciones.

**Casos de uso:** Los casos de uso definen las acciones que el usuario puede realizar en la aplicación. 

<img width="393" alt="image" src="https://user-images.githubusercontent.com/15202840/232626446-6b273e1b-a19a-4cbe-b222-cecaff2d6fcc.png">

