# Descripción
Éste es un proyecto de mantenedor de naves en SIFA, el cual permite crear una Nave nueva, editarla y visualizarla además de poder realizar una búsqueda por filtro a través: 
- Nombre de la Nave
- Señal distintiva (CBoCA) 
- Matrícula

# Requisitos
- Aplicación utiliza base de datos sifacb
- Para modificar configuración de base de datos, revisar archivo dentro del jar: mantenedor-0.0.1-SNAPSHOT.jar\BOOT-INF\classes\application.properties 

# Forma de empaquetar
- Desde eclipse: Run Maven Install
- Al contener archivos de configuración, jar es dependiente del ambiente

# Forma de ejecutar
- Debe utilizar Java 8 en path o bien indicarlo explícitamente al ejecutar
- como jar ejecutable desde línea de comandos. Ej: "c:\Program Files\Java\jdk1.8.0_331\bin\java.exe" -jar target\buscador_naves.jar

# Testing local
- Una vez levantado el servidor, abrir el navegador e ir a la URL http://localhost:8080/

# Otros
- Para mayor información, revise el manual de sistema

