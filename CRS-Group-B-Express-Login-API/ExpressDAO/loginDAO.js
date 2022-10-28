var mysql = require('mysql');

var con = mysql.createConnection({
    host: "localhost",  // local host / ip address of your machine
    user: "root",
    password: "root",
    database: "crsdatabase"
});

var USER_PASSWORD = "SELECT userID, username , password, role FROM User WHERE userID = ?";
var STUDENT_JOIN = "SELECT User.userID, User.username, User.role, Student.studentID, Student.name, Student.registrationApproved FROM Student INNER JOIN User ON User.userID=Student.studentID;";
var PROFESSOR_JOIN = "SELECT User.userID, User.username, User.role, Professor.professorID, Professor.name FROM Professor INNER JOIN User ON User.userID=Professor.professorID;";
var ADMIN_JOIN = "SELECT User.userID, User.username, User.role, Admin.adminID FROM Admin INNER JOIN User ON User.userID=Admin.adminID;";
