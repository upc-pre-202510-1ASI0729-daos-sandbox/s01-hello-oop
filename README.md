# s01-hello-oop

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE.md)

## Overview

This project is a sample Java application illustrating Object-Oriented Programming (OOP) and Domain-Driven Design (DDD) principles in a Customer Relationship Management (CRM) domain. It features two bounded contexts: CRM (for customer management) and Sales (for sales order management), implemented with Object-Oriented and Functional Java features.

### Authors
- **Open Source Application Development Team**

### Features
- **OOP Principles**: Encapsulation, immutability, and single responsibility
- **Domain-Driven Design Concepts**: Bounded contexts, aggregates, value objects
- **Java 22**: Records for value objects
- **Lombok**: Reduces boilerplate code
- **Maven**: Build management
- **Javadoc**: Comprehensive documentation

## Class Diagram
The following class diagram illustrates the structure of the application, including the main classes and their relationships.

![classDiagram](https://github.com/upc-pre-202510-1ASI0729-daos-sandbox/s01-hello-oop/blob/main/UML-ClassDiagram.png)


## Prerequisites
- Java 22 (JDK 22)
- Maven 3.6.0 or higher

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/upc-pre-202510-1ASI0729-daos-sandbox/s01-hello-oop.git
   cd s01-hello-oop

2. Build the project using Maven:
   ```bash
    mvn clean install
   ``` 
3. Run the application:
4. ```bash
   mvn exec:java -Dexec.mainClass="com.acme.oop.Main"
   ```

