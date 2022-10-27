# Metropolitan Convention Center - Data API

This repository is 1 of 3 microservices that make up the mock MCC Event Registration Application.
It provides a HyperSQLDB API for its adjacent authentication service - [mcc-auth](https://github.com/jaydajayda/mcc-auth.git) and ReactJS client - [mcc-client](https://github.com/jaydajayda/mcc-client.git).

## Getting Started

`git clone git@github.com:jaydajayda/mcc-data.git`

`cd mcc-data`

`gradle clean build bootJar`

`cd build/libs/`

`java -jar <JAR FILENAME>`

**Example:**

`java -jar mcc-data-0.0.1-SNAPSHOT.jar`



## Getting Started with Docker

**Build Data API Image & Verify Creation:**

`cd mcc-data`

`docker build --tag <IMAGE NAME>:v1.0 .`

`docker images`


**Create Docker Network:**

`docker network create <NETWORK NAME>`


**Start Data API Container & Add to Docker Network:**

`docker run -d --name <CONTAINER NAME> -p 8080:8080 <IMAGE NAME>:v1.0`

`docker network connect <NETWORK NAME> <CONTAINER NAME>`


**Locating IP Address of Data API:**

*(This IP Address will be required for the configuration of the Authentication API)*

`docker network inspect <NETWORK NAME>`