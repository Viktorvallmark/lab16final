public class Student {

  private String name;
  private String uni_ID;

  public Student(String name, String uni_ID) {
    if (!name.isBlank() || !name.isEmpty()) {
      this.name = name;
    }
    this.uni_ID = uni_ID;
  }

  public String getName() {
    return name;
  }

  public String getUni_ID() {
    return uni_ID;
  }

  public void setName(String name) {
    this.name = name;
  }
}
