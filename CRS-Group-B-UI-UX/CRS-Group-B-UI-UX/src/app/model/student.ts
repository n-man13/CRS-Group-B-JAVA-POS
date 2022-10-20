import { User } from "./user";

export class Student extends User{
    public id:number;
    public studentID: number;
    public name: string;
    public isRegistered:boolean;

    constructor(id: number, name: string, username:string, password:string, isRegistered:boolean) {
        super(id, username, password, 3);
        this.id = id;
        this.studentID = id;
        this.name = name;
        this.isRegistered = isRegistered;
    }
}
