Getting students
http method: get
url: http://localhost:8080/student
=======================
Putting new student
http method: post
url: http://localhost:8080/student
Dummy json 

{
"name" : "John",
"email" : "john@gmail.com",
"dob" : "1980-12-17"
}
=======================
Deleting a student
http method: delete
url: http://localhost:8080/student/{studentId}
e.g: http://localhost:8080/student/1
=======================
Update a student (name and email)
http method: put/patch
url :http://localhost:8080/student/1?key=vaue&key=value
eg: http://localhost:8080/student/1?name=Gift&email=gift@gmail.com