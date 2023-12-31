import java.util.ArrayList;

class University {
    private String u_name;
    private ArrayList < Student > students = new ArrayList < > ();
    private ArrayList < Department > departments = new ArrayList < > ();

    University(String[] sname, String[] dname, String u_name) {

        for (String name: sname) {
            students.add(new Student(name));
        }
        for (String name: dname) {
            departments.add(new Department(name));
        }
        this.u_name = u_name;
    }

    String getName() {
        return u_name;
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
    void print_student_name(String d_name) {
        Department department = getDepartment(d_name);
        if (department != null) {
            System.out.println("Students in Department " + d_name + ":");
            for (Student student : department.getStudents()) {
                System.out.println(student.getSname());
            }
        } else {
            System.out.println("Department " + d_name + " not found.");
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
    public ArrayList<Student> getStudents() {
        return std;
    }
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
                "Akram",
                "Akeel",
        };
        String[] departmentNames = {
                "Computer Science",
                "Mathematics",
                "Physics"
        };

        University university = new University(studentNames, departmentNames, "Mehran.\n");

        System.out.println("\nUniversity Name : " + university.getName());
        System.out.println("List of Students and Departments is given.\n");


        university.enrollIn(university.getDepartment("Computer Science"),university.getStudent("Ali"));
        university.enrollIn(university.getDepartment("Mathematics"),university.getStudent("Ajaz"));
        university.enrollIn(university.getDepartment("Physics"), university.getStudent("Akram"));
        university.enrollIn(university.getDepartment("Physics"), university.getStudent("Akeel"));

        university.display();

        System.out.println();
        university.print_student_name("Physics");

    }
}