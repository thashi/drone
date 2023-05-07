Java version 17

Entity level validations are included.
Unit test is incomplete

inbuilt db H2

    username : musala
    password : password

mvn package -B

Get all drones

GET : http://localhost:8080/drone

Register a drone

POST : http://localhost:8080/drone

body : 
{
"serialNumber": "EEE+_",
"model": "CRUISERWEIGHT",
"weightLimit": 256.0,
"batteryCapacity": 1.0,
"state": "IDLE"
}

Load medication

PUT : http://localhost:8080/drone/6

body :
{
"medications": [
{
"name": "Citral",
"code": "GKLL1_A",
"weight": 70,
"imageUrl": "hghghghggh"
},
{
"name": "Citralo",
"code": "GKLL1_B",
"weight": 80,
"imageUrl": "hghghghggh"
},
{
"name": "Citraln",
"code": "GKLL1_C",
"weight": 90,
"imageUrl": "hghghghggh"
}
]
}

Get drone by state

GET : http://localhost:8080/drone/filter?state=RETURNING

Get loaded medication by drone serial

GET : http://localhost:8080/drone/loaded?serial=FFF+_