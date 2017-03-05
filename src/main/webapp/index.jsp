<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rainy Hills</title>
</head>
<body>
<b>Rainy Hills</b>
<p></p>
@author Valentin Chiriac
<p></p>
REST services:
<p></p>
GET: http://localhost:8080/ee-array-1/rest/volume/dummy
<p></p>
    - generates a dummy json which can be used (also modified and used) as input data:
<p></p>
{
"blocks" : [ {
"height" : 2
}, {
"height" : 1
}, {
"height" : 4
} ]
}
<p></p>

POST: http://localhost:8080/ee-array-1/rest/volume/calculate
<p></p>
    - calculates the required volume based on the input json (set the content-type to application/json)


</body>
</html>
