<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rainy Hills</title>
</head>
<body>
Rainy Hills
@author Valentin Chiriac
The application is built on Java EE with JAX-RS REST Services for easy testing.
It can be deployed in jboss AS Server (I used version 7.1.1)

1. maven clean install
2. copy generated war file to jboss/standalone/deployments
3. start jboss server
4. application has 2 REST services for client communication:
a. GET: http://localhost:8080/ee-array-1/rest/volume/dummy - generates a dummy json
which can be used (also modified and used) as input data:
{
"blocks" : [ {
"height" : 2
}, {
"height" : 1
}, {
"height" : 4
} ]
}

b. POST: http://localhost:8080/ee-array-1/rest/volume/calculate - calculates the required volume
based on the input json (set the content-type to application/json)

The solution used has complexity O(n) and is done in 1 pass
a. left = 0 and right = n-1;
b. find the hill of max height from left and right.
c. the minimum of the two is subtracted from the array element

</body>
</html>
