export class Student {

    private name:string;
    private email:string;
    private password:string;
    private subjects :string[];

    constructor(name:string,email:string,password:string,subjects:string[] = []){
        this.name = name;
        this.email = email;
        this.password = password;
        this.subjects = subjects;
    }
}
