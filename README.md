# jdbi-exampe
Author: Felix Daniel Campoa, felixcampoa@gmail.com
# Instructions

- Make sure that you have docker running in your pc.
- Run "docker compose up --build" the first time you run the project, and only "docker compose up" the following times.
- After run docker command, tha database container will start
- Open the project with intellij and make sure you download the dependencies by building the project, or clicking directly in the Maven panel, or running "mvn install" from the console.

- To connect to the database instance(mysql), you can use the following connection settings:
- - server: localhost
- - port: 3306
- - user: root
- - password: root
- - database: pos

- you can also see the database configuration in the compose.yaml file.
- There a UML class diagram in the root of the project as well.