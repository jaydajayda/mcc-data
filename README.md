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


