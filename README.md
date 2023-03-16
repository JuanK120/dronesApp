# Drones-App

this mock app was developped with the idea that it created for the use of drones to transport medications.
this app allows to:

* register a drone.
* load a drone with medication items.
* check loaded medication items for a given drone.
* check available drones for loading.
* check drone battery level for a given drone.

the app was create following the ER diagram:

![image](https://drive.google.com/uc?export=view&id=1SmaEVPZTG-2zjqjHOaIEg-YfqSB6vIQ6)

the App was developped using Java 17, Maven 3.8.6, Spring 3.0.4, Spring-Web , JPA and PostgreSql 

## Index ##

[Start](#Drones-App)

[Configuration](#Configuration)

[Execution](#Execution)

[End-Points](#End-Points)

# Configuration

The app has a main configuration file, named aplication.properties, in which are the main configurations for the app to run,
bar the conection to the database, that is added in the profile properties.

to declare a profile to add the Database conection you must create in the same path as aplication.properties a file following
the pattern application-[profile-name].properties, as shown next: 

![image](https://drive.google.com/uc?export=view&id=1eO6iHr2Fd8t7u4D2AB12vhTpIMhDU6Vg)

and add the conection information such as the driver you are using, the dialect, the host, username and password.

![image](https://drive.google.com/uc?export=view&id=1PqsMub8MkgTp7zXlku-pFJl_g2G60AXk)

aditionally, it is recommended that for developement build/Execution you add the properties 

* `spring.jpa.hibernate.ddl-auto=none` : as it is assumed that the dba would have already created the database and is 
in charge of both the adding of necessary data for the app to function correctly, otherwise, by default, for
developement and test purposes, everytime the app is executed, a new database and initial data are created.

* `spring.jpa.show-sql=false` : as it is there by default for debugging reasons, so it is not needed for production.

#  Execution

to execute the App you must open the console and go to the directory the project is in, then you execute the command:

`mvn spring-boot:run -Dspring.profiles.active={profile-to-use}`

that should run the app with the profile chosen, allowing you to use different databases for development, testing or,
deployment reasons.

#  End Points

the app has multiple services that allows to look for information of the database and to operate the drones.

## drone_state

this service allows to look up the various states a drone can be in, for future use.


route : _{host}:{port}/api/v0/drone_state_

@Get : returns all drone states registered in the database.


route : _{host}:{port}/api/v0/drone_state/{id}_

@Get : returns the drone states registered in the database with that id.


## model

this service allows to look up the various models of drones, for future use.


route : _{host}:{port}/api/v0/model_

@Get : returns all drone models registered in the database.


route : _{host}:{port}/api/v0/model/{id}_

@Get : returns the drone model registered in the database with that id.

## drone

this service allows to register new drones and to look for information on the drones already registered in the database.


route : _{host}:{port}/api/v0/drone_

@Get : returns all drone models registered in the database.

@Post : registers a new drone. it recieves a json containing the information of the new drone, following the structure:

```
{
    "serial_number" : "{serial number of new drone}",    
    "battery_capacity": {integer from 0 to 100 representing the percentage the battery of the drone has at the moment},    
    "state": {state registered in db},    
    "model":{model registered in db}
}

```

route : _{host}:{port}/api/v0/drone/{id}_

@Get : returns the drone registered in the database with that id.

route : _{host}:{port}/api/v0/drone/getBattery/{id}_

@Get : returns the value of the battery registered in the database for the drone with that id.

route : _{host}:{port}/api/v0/drone/availableDrones_

@Get : returns all the available drones in the database, meaning, the drones with a battery greater than 25(%),
and that still have weight available before reaching their weight limit.


## medications

this service allows to look for information on the medications already registered in the database.


route : _{host}:{port}/api/v0/medication_

@Get : returns all medications registered in the database.

route : _{host}:{port}/api/v0/medication/{id}_

@Get : returns the medication registered in the database with that id.


## transport

this service allows to load drones with medications registered in the database, to deliver said medication, and to get the payload a drone already has.
this is done bi creating a registry of when a drone id loaded with medication, storing both which drone was loaded, which medication, and if it has
already been delivered or not.


route : _{host}:{port}/api/v0/transport_

@Post : loads a drone with medication. for this it creates a new registry of transportation, recieving
the information in a json document following the structure:
```
{
    "pickup_date": "{yyyy-mm-dd}",
    "drone": {drone registered in the database},
    "medication": {medication registered in the database}
}
```

@Put : marks a transport registry as delivered, meaning that the drone already delivered the medication.
for this, we send a transport registry already registered in the database in json format.

route : _{host}:{port}/api/v0/transport/getPayload/{id}_

@Get : returns the undelivered transport registries in the database for the drone with that id.








