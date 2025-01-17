import java.util.Objects;

/** Faculty */
public class Faculty {

  private Program[] programs;
  private Teacher[] teachers;
  private String facultyName;
  private int programIndex;

  public Faculty(String facultyName, int amountOfPrograms, int amountOfTeachers) {
    if (facultyName.isBlank()) {
      this.facultyName = "Temp faculty name";
    } else {
      this.facultyName = facultyName;
    }
    if ((amountOfPrograms > 0) && (amountOfTeachers > 0)) {
      this.programs = new Program[amountOfPrograms];
      this.teachers = new Teacher[amountOfTeachers];
    }
    if ((amountOfPrograms > 0)) {
      assert programs != null;
      this.programIndex = programs.length;
    }
  }

  private int getProgramIndex(String programName) {
    return programIndex;
  }

  public String removeStudentFromProgram(String studentName, String programName) {
    int temp = 0;
    for (Program program : programs) {
      if (!(program.getProgramName().equals(programName))) {
        temp++;
      }
      if (program.getProgramName().equals(programName)) {
        String stud = findStudent(studentName, programName);
        if (stud.equals("Studenten är registrerad.")) {
          for (int i = 0; i < program.getStudents().length; i++) {
            if (!(program.getStudents()[i].getName().equals(studentName))) {
            } else {
              program.getStudents()[i] = null;
              return "Student borttagen.";
            }
          }
        } else {
          return "Student fanns ej i programmet.";
        }
      }
    }
    if (temp == programs.length) {
      return "Inget program med det namnet.";
    }
    return "-1";
  }

  public String checkIfTeacherExists(String teacherName) {
    if (this.teachers != null) {
      for (Teacher teacher : teachers) {
        if (teacher != null) {
          if (Objects.equals(teacher.toString(), teacherName)) {
            return "Läraren tillhör fakulteten.";
          }
        }
      }
      return "Läraren tillhör inte fakulteten.";
    }
    return "-1";
  }

  public String addCoursesToProgram(Course[] courses, String programName) {
    for (Program program : programs) {
      if (Objects.equals(program.getProgramName(), programName)) {
        if (program.getCourses().length == courses.length) {
          program.setCourses(courses);
          return "Kurser adderade.";
        } else {
          return "Fler kurser än tillåtet.";
        }
      } else {
        return "Inget program med det namnet.";
      }
    }
    return "-1";
  }

  public String getFacultyName() {
    return this.facultyName;
  }

  public String addStudentToProgram(String programName, Student student) {
    int temp = 0;
    for (Program program : programs) {
      if (!(program.getProgramName().equals(programName))) {
        temp++;
      } else {
        for (int i = 0; i < program.getStudents().length; i++) {
          if (program.getStudents()[i] == null) {
            program.getStudents()[i] = student;
            return "Student tillagd i programmet.";
          } else {
            return "Programmet är fullt.";
          }
        }
      }
      if (temp == programs.length) {
        return "Inget program med det namnet.";
      }
    }

    return "-1";
  }

  public String addProgram(String programName, int amountOfCourses, int amountOfStudents) {
    int temp = 0;
    for (int i = 0; i < programs.length; i++) {
      if (programs[i] == null) {
        programs[i] = new Program(programName, amountOfCourses, amountOfStudents);
        return "Program tillagt.";
      } else {
        temp++;
      }
    }
    if (programs.length == temp) {
      return "Max antal program tillagda.";
    }
    return programName;
  }

  public String[] getProgramNames() {
    String[] temp = new String[programs.length];
    for (int i = 0; i < programs.length; i++) {
      temp[i] = programs[i].getProgramName();
    }
    return temp;
  }

  public String findStudent(String studentName, String programName) {
    for (Program program : programs) {
      if (Objects.equals(program.getProgramName(), programName)) {
        for (Student student : program.getStudents()) {
          if (Objects.equals(student.getName(), studentName)) {
            return "Studenten är registrerad.";
          } else {
            return "Studenten är inte registrerad på programmet.";
          }
        }
      }
    }
    return "Student är inte registrerad på programmet.";
  }

  public String addTeachersToFaculty(Teacher[] newTeachers) {

    if (teachers.length != newTeachers.length) {
      return "För många valda lärare.";
    } else {
      this.teachers = newTeachers;
      return "Added new teachers to faculty";
    }
  }

  public String findStudentByID(String uniID, String programName) {
    int temp = 0;
    for (Program program : programs) {
      if (program != null) {
        for (Student student : program.getStudents()) {
          if (student != null) {
            if (student.getUni_ID().equals(uniID)) {
              return student.getName();
            }
          } else {
            temp++;
          }
        }
        if (temp == program.getStudents().length) {
          return "Inget namn finns associerat med detta student-ID.";
        }
      }
    }
    return "Inget namn finns associerat med detta student-ID.";
  }
}
