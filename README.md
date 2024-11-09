# Nails Salon
Esta aplicacion refleja el modulo backend de un salon de belleza para las unas. El repositorio aloja el aplicativo redactado en Springboot que da soporte al panel de manejo de productos, articulos e items.

## Instalacion
Para ejecutar la aplicacion se requiere disponer de un entorno configurado con:
- **JDK 21 LTS**
- **Maven**
- **MySQL**

1. Clonar el repositorio y navegar al root.
```bash
# Clonar fork
$ git clone https://github.com/ingenieria-software-2024/nails-back.git
$ cd nails-back
$ pwd
/home/user/nails-back
```

```bash
# Clonar repositorio oficial
$ git clone https://github.com/Programacion-Avanzada-UTN-FRVM/nails-back.git
$ cd nails-back
$ pwd
/home/user/nails-back
```

2. Realizar una instalacion limpia de dependencias.
```bash
$ mvn clean install
```

3. Configurar el archivo `application.yaml` para apuntar a la instalacion local.
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/js_nails_db?createDatabaseIfNotExist=true
    username: root
    password: test1234
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update

    show-sql: true
  main:
    banner-mode: off

path:
  cors: http://localhost:3000
  mapping: nails

page:
  max: 9
```

4. Ejecutar la aplicacion, sera accesible desde el puerto `8080`.
```bash
$ mvn spring-boot:run
```

## Creditos
Este proyecto es oficialmente realizado con fines academicos para observar la tarea de **refactoring** y **mantenimiento** de software.

- Proyecto original por **Juan Jose Vanzetti**
- Refactoring realizado por **DUKI Team**
  - Lucas 'punteroo' Maza
  - Santiago 'Pedraza11' Pedraza
  - Nicolas Nahuel 'NicolasMairone' Mairone
  - Guido 'guidoserniotti' Serniotti
  - Alvaro 'Ibarra1812' Ibarra
  - Damaris 'damaris412' Torres