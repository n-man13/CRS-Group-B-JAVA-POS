var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/mydb";

class mongoDAO {




    constructor() {
    }

    login(body, callBack) {

        MongoClient.connect(url, function (err, db) {
            if (err) throw err;
            var dbo = db.db("crslogin");
            dbo.collection("users").find(body).toArray(function (err, result) {
                if (err) throw err;
                if (result.length == 0) callBack(new Error('Wrong credentials'), null);
                if (body.role == 3 && !result.registrationApproved) {
                    return callBack(new Error('Your registration is not approved'), null);
                }
                else {
                    return callBack(null, result[0]);
                }
            })
        })
    }
}      

module.exports = mongoDAO;

