
public class Student {
	private double grade;
	private String name;
	
	public Student() {
		
	}
	
	public Student(String name, double grade) {
		this.grade = grade;
		this.name = name;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [grade=" + grade + ", name=" + name + "]";
	}
	
	
}



