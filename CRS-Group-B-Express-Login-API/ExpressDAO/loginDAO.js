var mysql = require('mysql');

var con = mysql.createConnection({
    host: "localhost",  // local host / ip address of your machine
    user: "root",
    password: "root",
    database: "crsdatabase"
});

