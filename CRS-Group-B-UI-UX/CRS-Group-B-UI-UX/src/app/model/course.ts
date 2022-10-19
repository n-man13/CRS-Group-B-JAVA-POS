import { Professor } from "./professor";

export class Course {
    public id:number;
    public courseID: number;
    public name: string;
    public description: string;
    public department: string;
    public professorID: number;
    public prereqID: number;

    constructor(id:number, courseID: number, name: string, description: string, department: string, prereqID: number, professorID: number) {
        this.id = id;
        this.courseID = courseID;
        this.name = name;
        this.description = description;
        this.department = department;
        this.professorID = professorID;
        this.prereqID = prereqID;
    }
}
