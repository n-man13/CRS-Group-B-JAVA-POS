import { Professor } from "./professor";

export class Course {
    public courseID: number;
    public name: string;
    public description: string;
    public department: string;
    public professor: Professor;
    public prereqCourse: Course;

    constructor(courseID: number, name: string, description: string, department: string, prereqCourse: Course, professor: Professor) {
        this.courseID = courseID;
        this.name = name;
        this.description = description;
        this.department = department;
        this.professor = professor;
        this.prereqCourse = prereqCourse;
    }
}
