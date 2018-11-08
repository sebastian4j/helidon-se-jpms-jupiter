# Java, Módulos y Microservicios
Este repositorio contiene un servicio que responde a /api con un mensaje de saludo utilizando **maven, helidon se, jpms, jsonb, junit jupiter y docker** para construir la imagen final.

## Requisitos

- Maven
- JDK 11
- Docker
- JAVA_HOME
- Bash

## Construcción
Para construir la aplicación basta con ejecutar **mvn clean package install** y se realizará todo el proceso hasta generar la imagen docker. Hay que tener definida la variable de entorno JAVA_HOME y tener instalado Docker. 

En el pom.xml esta definido que se ejecute el archivo build.sh el cual genera el jre y la imagen docker con la aplicación finalizada.

