# Java RMI HTTP streaming & Web hooks
Using Java RMI, implementation of two web protocols :
- HTTP streaming
- Web hooks

*HTTP streaming is only sketched on the PDF file named `rapport.pdf`*

## Members of the team
The two developers of this team are :
- BOUNOUAS Nassim
- GARDAIRE Loïc

## Project structure
This project is divided in two different parts :
- the server where the clients can connect : is in the directory `rmipubsubserver`.
- the client implementation : is in the directory `rmipubsubclient`.

## How to build the project
Use `mvn install` inside both folders : rmipubsubserver and rmipubsubclient

## How to run the project

Use `mvn exec:java` firstly on server and on client how many times you want.

The project handles concurrency on clients, so you can run multiple clients.
