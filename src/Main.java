import java.util.ArrayList;

class University {
    private String name;
    private ArrayList < Student > students = new ArrayList < > ();
    private ArrayList < Department > departments = new ArrayList < > ();

    University(String[] sname, String[] dname) {

        for (String name: sname) {
            students.add(new Student(name));
        }
        for (String name: dname) {
            departments.add(new Department(name));
        }
    }

    Department getDepartment(String dkey) {
        for (Department department: departments) {
            if (department.getDname().equals(dkey)) {
                return department;
            }
        }
        return null;
    }

    Student getStudent(String skey) {
        for (Student student: students) {
            if (student.getSname().equals(skey)) {
                return student;
            }
        }
        return null;
    }

    void enrollIn(Department d, Student s) {
        d.addStudent(s);
        s.setDept(d);
    }

    void display() {
        for (Department department: departments) {
            System.out.println("Department: " + department.getDname());
            department.display();
            System.out.println("---------------------------------");
        }
    }
}

class Student {
    private String sname;
    private Department dept;

    Student(String sname) {
        this.sname = sname;
    }

    String getSname() {
        return this.sname;
    }

    void setDept(Department d) {
        this.dept = d;
    }

    public String toString() {
        return sname;
    }

}

class Department {
    private String dname;
    private ArrayList < Student > std = new ArrayList < > ();

    Department(String dname) {
        this.dname = dname;
    }

    public String getDname() {
        return this.dname;
    }

    public void addStudent(Student s) {
        std.add(s);
    }

    public void display() {
        for (int i = 0; i < std.size(); i++) {
            //            System.out.println(Student.get(i).getsname());
            System.out.println("Student : " + std.get(i));
        }
    }
}


class Main {
    public static void main(String[] args) {

        String[] studentNames = {
                "Ali",
                "Ajaz",
                "Akram"
        };
        String[] departmentNames = {
                "Computer Science",
                "Mathematics",
                "Physics"
        };

        University university = new University(studentNames, departmentNames);

        Department csDepartment = university.getDepartment("Computer Science");
        Department mathDepartment = university.getDepartment("Mathemkaatics");
        Department physicsDepartment = university.getDepartment("Physics");

        Student alice = university.getStudent("Ali");
        Student bob = university.getStudent("Ajaz");
        Student charlie = university.getStudent("Akram");

        university.enrollIn(csDepartment, alice);
        university.enrollIn(mathDepartment, bob);
        university.enrollIn(physicsDepartment, charlie);

        university.display();


    }
}