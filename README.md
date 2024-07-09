# IMC Web Application

## Descripción

Esta es una aplicación web desarrollada en Java para calcular el Índice de Masa Corporal de los usuarios. Los usuarios pueden registrarse, iniciar sesión, calcular su IMC y ver un historial de sus resultados.

## Funcionalidades

- **Registro de Usuarios:** Los usuarios pueden registrarse proporcionando su nombre completo, edad, sexo, estatura, nombre de usuario y contraseña.
- **Inicio de Sesión:** Los usuarios pueden iniciar sesión utilizando su nombre de usuario y contraseña.
- **Cálculo del IMC:** Los usuarios pueden calcular su IMC ingresando su peso.
- **Historial de IMC:** Los usuarios pueden ver un historial de sus resultados de IMC.

## Tecnologías Utilizadas

- Java
- JSP
- Servlets
- MySQL
- HTML/CSS
- JDBC
- Jakarta EE

## Configuración del Entorno

1. **Instalar JDK 11:** Asegúrate de tener instalado JDK 11 en tu máquina.
2. **Instalar Apache Tomcat v10.1:** Descarga e instala Apache Tomcat 10.1.
3. **Configurar MySQL:** Configura una base de datos MySQL y actualiza las credenciales en el archivo `DBConnection.java`.

## Instrucciones de Instalación

1. **Clonar el repositorio:**

    ```bash
    git clone https://github.com/Alejandro-Avila-Aldaco/imc-web-application.git
    cd imc-web-application
    ```

2. **Importar el proyecto en Eclipse:**
    - Abre Eclipse.
    - Selecciona `File` > `Import`.
    - Elige `Existing Projects into Workspace` y selecciona la carpeta del proyecto clonado.

3. **Configurar Apache Tomcat en Eclipse:**
    - Ve a `Window` > `Preferences`.
    - Selecciona `Server` > `Runtime Environments` > `Add`.
    - Elige `Apache Tomcat v10.1` y proporciona la ruta de instalación.

4. **Configurar la base de datos:**
    - Crea una base de datos en MySQL.
    - Actualiza las credenciales de la base de datos en `DBConnection.java`.

5. **Desplegar y ejecutar la aplicación:**
    - Haz clic derecho en el proyecto en Eclipse.
    - Selecciona `Run As` > `Run on Server` y elige Apache Tomcat v10.1.

## Estructura del Proyecto

- **src/**
  - **controller/**
    - `Login.java`
    - `Register.java`
    - `ImcResultado.java`
  - **model/**
    - `User.java`
  - **util/**
    - `DBConnection.java`
    - `ImcResultadoUtil.java`
- **WebContent/**
  - **css/**
    - `styles.css`
  - **WEB-INF/**
    - `web.xml`
  - `index.jsp`
  - `login.jsp`
  - `register.jsp`
  - `imcresultado.jsp`

## Autor

- Alejandro Avila https://github.com/Alejandro-Avila-Aldaco
