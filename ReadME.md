# Configuración de la Base de Datos

Para conectar a la base de datos en la nube, use las siguientes credenciales:

- Hostname: ep-proud-shadow-a5kn4shv.us-east-2.aws.neon.tech
- Username: neondb_owner
- Password: NuE5P3YDFGko
- Database: neondb
- PortName: 5432


## Configuración del persistence.xml

<?xml version="1.0" encoding="UTF-8"?>
<persistence version="3.0" xmlns="https://jakarta.ee/xml/ns/persistence" 
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
             xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence https://jakarta.ee/xml/ns/persistence/persistence_3_0.xsd">
    <!-- Define Persistence Unit -->
    <persistence-unit name="pu" transaction-type="JTA">
        <jta-data-source>jdbc/webappneon</jta-data-source>
        <shared-cache-mode>NONE</shared-cache-mode>
        <properties>
            <property
            name="jakarta.persistence.schema-generation.database.action"
            value="create" />
        </properties>
    </persistence-unit>
</persistence>
