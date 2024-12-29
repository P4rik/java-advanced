# Laboratory work №3
***
### Theme: Annotation Processors in Java
### Author: IO-24 Parovenko Danylo
### Number of the Grade items.Book: 2419
### Task: 2419 % 3 = 1
***
# How to Build and Run:
***
### 1. Clone the repository to your local machine:
```bash
git clone https://github.com/P4rik/java-advanced.git
```
### 2. Navigate to the lab folder:
```bash
cd java-advanced/Lab3
```
### 3. Use the javac and java commands to compile:
```bash
javac -d out src/Main.java src/model/*.java src/annotation/*.java src/serializer/*.java
java --enable-preview -cp out Main
```