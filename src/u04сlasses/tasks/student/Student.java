package u04сlasses.tasks.student;

public class Student {

    private String fullName;
    private String group;
    private int[] grade;

    public Student(String fullName, String group, int[] grade) {
        this.fullName = fullName;
        this.group = group;
        this.grade = grade;
    }

    public static void print(Student[] students) {

        System.out.println("\nTable - Students");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Full Name\t\t|\tFaculty\t |\t\t\tMarks");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < students.length; i++) {
            String marks = "";
            for (int k = 0; k < students[i].grade.length; k++) {
                marks += String.format("%2d", students[i].grade[k]) + "|";
            }
            System.out.printf("%-15s | %10s |\t\t%s\n", students[i].fullName, students[i].group, marks);
        }
        System.out.println("-------------------------------------------------------------");
    }

    public static boolean printExcellentStudent(Student[] students) {

        int count = 0;

        System.out.println("\nTable - Excellent students");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Full Name\t\t|\tFaculty\t |");
        System.out.println("-------------------------------------------------------------");
        for (Student student : students) {

            boolean isExcellentStudent = true;

            for (int grade : student.grade) {
                if (grade < 9) {
                    isExcellentStudent = false;
                }
            }

            if (isExcellentStudent == true) {
                System.out.printf("%-15s | %10s |\n", student.fullName, student.group);
                count++;
            }
        }
        System.out.println("-------------------------------------------------------------");

        if (count > 0)
            return true;
        else
            return false;
    }
}