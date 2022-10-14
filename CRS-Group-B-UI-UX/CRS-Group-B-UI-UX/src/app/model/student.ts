import { User } from "./user";

export class Student extends User{
    public studentID: number;
    public name: String;

    constructor(id: number, name: String, username:string, password:string) {
        super(id, username, password, 3);
        this.studentID = id;
        this.name = name;
    }
}
