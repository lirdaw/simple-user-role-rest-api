# Simple user-role rest API

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Requirements](#requirements)
* [Setup](#setup)

## General info
This project is a simple example of the REST API for a user-role relationship.

After successful setup you will have access for beautiful home page at http://localhost:8080/ which describes all endpoints which this project has to offer.

![alt text](https://raw.githubusercontent.com/lirdaw/simple-user-role-rest-api/master/readme_img001.png "Home Page")

## Technologies
* Spring Boot (2.2.4 released)
* MySQL

## Requirements
* JDK 8
* Maven 3

## Setup
1) Initialize MySQL database with use of following [script](https://github.com/lirdaw/simple-user-role-rest-api/blob/master/init_database.sql).
2) Run MySQL database.
3) Build Spring Boot Project with Maven

    `mvn install`
4) Run Spring Boot App with Maven

    `mvn spring-boot:run`