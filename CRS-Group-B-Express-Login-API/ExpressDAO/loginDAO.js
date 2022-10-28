var mysql = require('mysql');  // External module for Node/Express
// code to test connection with NOde 
class loginDAO {




    constructor() {

        //this.customer = new Customer("", "");

    }

    login(body, callBack) {

        let con = mysql.createConnection({
            host: "localhost",  // local host / ip address of your machine
            user: "root",
            password: "root",
            database: "crsdatabase"
        });

        con.connect(function (err) {
            if (err) throw err;
            const USER_PASSWORD = "SELECT userID, username , password, role FROM User WHERE username = ? AND password = ? AND role=?";
            con.query(USER_PASSWORD, [body.username, body.password, body.role], function (err, result) {
                if (err) throw err;
                if (result == null) throw new Error('Wrong credentials');
                if (body.role == 3) {
                    var STUDENT_JOIN = "SELECT User.userID, User.username, User.role, Student.studentID, Student.name, Student.registrationApproved FROM Student INNER JOIN User ON User.userID=Student.studentID WHERE User.username=?;";
                    con.query(STUDENT_JOIN, [body.username], function (err, result) {
                        if (err) throw err;
                        if (result.registrationApproved) {
                            return callBack(null, result);
                        }
                    })
                }
                else if (body.role == 2) {
                    var PROFESSOR_JOIN = "SELECT User.userID, User.username, User.role, Professor.professorID, Professor.name FROM Professor INNER JOIN User ON User.userID=Professor.professorID WHERE User.username=?;";
                    con.query(PROFESSOR_JOIN, [body.username], function (err, result) {
                        if (err) throw err;
                        return callBack(null, result);
                    })
                }
                else if (body.role == 1) {
                    var ADMIN_JOIN = "SELECT User.userID, User.username, User.role, Admin.adminID FROM Admin INNER JOIN User ON User.userID=Admin.adminID WHERE User.username=?;";
                    con.query(ADMIN_JOIN, [body.username], function (err, result) {
                        if (err) throw err;
                        return callBack(null, result);
                    })
                }
            })

        });

    }

}

module.exports = loginDAO;

