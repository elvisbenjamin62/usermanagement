# usermanagement
UserManagement-MongoDB-SpringBoot-CRUD
A User Management Spring Boot application with basic CRUD operation using MongoDB to store data

Rest API Resources
User:
1. GET /users
	Fetches all users from repo
2. GET /users/{id}
	Fetches unique user from repo with given id
3. POST /users
	Adds new user to repo with details from POST body
4. PUT /users/{id}
	Updates user of id in repo with PUT body
5. DELETE /users/{id}
	Deletes user from repo with id
6. GET /searchusers?lastName=%something%&firstName=%something%
	Fetches users from repo who match filter condition
	
Note: Update Applicaiton properties as required
server.port=8081
mydatabase.mongodb.address=localhost
mydatabase.mongodb.db=mytestdb
