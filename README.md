Rainy Hills

@author: Valentin Chiriac

The application is built on Java EE with JAX-RS REST Services for easy testing. 

It can be deployed in jboss AS Server (I used version 7.1.1)

Other tools used:
 - apache-maven-3.3.9
 - java version "1.7.0_80"

INSTALL:

1. maven clean install
2. copy generated war file to jboss/standalone/deployments
3. start jboss server
4. the application contains 2 REST services thet can be called:

 a. GET: http://localhost:8080/ee-array-1/rest/volume/dummy 
	- generates a dummy json, which can be used (also modified and used) as input data:
 {
  "blocks" : [ {
    "height" : 2
  }, {
    "height" : 1
  }, {
    "height" : 4
  } ]
}
 
 b. POST: http://localhost:8080/ee-array-1/rest/volume/calculate 
	- calculates the required volume based on the input json (set the content-type to application/json)

SOLUTION

The solution used has complexity O(n) and this is done in 1 pass:
a. take left = 0 and right = n-1;
b. find the maximum height from left and right.
c. then the minimum of the two is substracted from the array
