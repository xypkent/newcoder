package myself;

import java.util.Arrays;
import java.util.Comparator;


public class MyComparator {

	public static class Student {
		public String name;
		public int id;
		public int age;

		public Student(String name, int id, int age) {
			this.name = name;
			this.id = id;
			this.age = age;
		}
	}

	public static class AscendComparatio implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			return o1.age - o2.age;
		}

	}

	public static void main(String[] args) {

		Student student1 = new Student("ะกล๔1", 1, 18);
		Student student2 = new Student("ะกล๔2", 2, 19);
		Student student3 = new Student("ะกล๔3", 3, 20);

		Student[] students = new Student[] { student3, student2, student1 };

		Arrays.sort(students,new AscendComparatio());

	}

}















