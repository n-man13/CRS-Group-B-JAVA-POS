export class RegisteredCourse {
    public courseID: number;
    public studentID: number;
    public feePaid: boolean;
    public grade: number;

    constructor(courseID: number, studentID: number){
        this.courseID = courseID;
        this.studentID = studentID;
        this.feePaid = false;
        this.grade = -1;
    }
}
