# WebServiceMonitoreo
Web service para recibir señales de los dispositivos médicos y enviar a un websocket la información recibida a menra de broadcast.

### Compilando el proyecto

Para desplegar en azure deberemos crear un artefacto tipo war y agregar el plugin necesario.

Agregar al pom del proyecto:
```
<packaging>war</packaging>
```
Agregar plugin de azure:

```
<?xml version="1.0"?>
<plugin>
  <groupId>com.microsoft.azure</groupId>
  <artifactId>azure-webapp-maven-plugin</artifactId>
  <version>1.1.0</version>
  <configuration>
    <!-- configure app to run on port 80, required by App Service -->
    <appSettings>
      <property>
        <name>JAVA_OPTS</name>
        <value>-Dserver.port=80</value>
      </property>
    </appSettings>
    <!-- Web App information -->
    <resourceGroup>webservices</resourceGroup>
    <appName>ws-medical-device</appName>
    <region>westus2</region>
    <!-- Java Runtime Stack for Web App on Linux -->
    <linuxRuntime>tomcat 8.5-jre8</linuxRuntime>
  </configuration>
</plugin>
```

Para generar el artefacto del proyecto y desplegarlo en azure abrimos una consola CLI de azure en el entorno de desarrollo, nos ubicamos en
el folder del proyecto haciendo uso de la instrucción **cd** y ejecutamos la siguiente instrucción:

```
mvn azure-webapp:deploy
```

Esperamos que termine la ejecución y ya tendremos la aplicación desplegada en Azure con su respectivo endpoint.

## Build With

* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [SpringBoot](https://spring.io/projects/spring-boot) - Para la construcción de la aplicación
* [SpringBoot initializr](https://start.spring.io/) - Para generación del artefacto

## License

This project is licensed under the Apache License 2.0 License
