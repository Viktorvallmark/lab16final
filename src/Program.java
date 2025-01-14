/** Program */
public class Program {

  private Student[] students;
  private String programName;
  private Course[] courses;

  public Program(String programName, int amountOfCourses, int amountOfStudents) {

    if (!programName.isBlank() && !programName.isEmpty()) {
      this.programName = programName;
    }

    if ((amountOfCourses > 0) && (amountOfStudents > 0)) {
      this.students = new Student[amountOfStudents];
      this.courses = new Course[amountOfCourses];
    }
    if(amountOfStudents < 1){
      this.students = new Student[1];
    }
  }

  public Student[] getStudents() {
    return students;
  }

  public String getProgramName() {
    return programName;
  }

  public Course[] getCourses() {
    return courses;
  }

  public String addStudent(Student student) {
    for (int i = 0; i < students.length; i++) {
      if (students[i] == null) {
        students[i] = student;
        break;
      }
    }
    return "Student: "
        + student.getName()
        + " with id: "
        + student.getUni_ID()
        + " has been created.";
  }

  public void setCourses(Course[] courses) {
    this.courses = courses;
  }

  public String removeStudent(String studentName) {

    for (Student student : students) {
      if (student.getName() == studentName) {
        student = null;
      }
    }

    return "Student: " + studentName + " has been removed";
  }
}
