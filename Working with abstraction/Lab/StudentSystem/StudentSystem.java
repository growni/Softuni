package abstractions.Lab.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repository;

    public StudentSystem() {
        this.repository = new HashMap<>();
    }

    public Map<String, Student> getRepository() {
        return this.repository;
    }

    public void ParseCommand(String[] command) {

        if (command[0].equals("Create")) {
            create(command);
        } else if (command[0].equals("Show")) {
            String name = command[1];
            if (repository.containsKey(name)) {
                String view = show(name);
                System.out.println(view);
            }
        }
    }

    private String show(String name) {
        Student student = repository.get(name);
        String view = String.format("%s is %s years old.", student.getName(), student.getAge());

        if (student.getGrade() >= 5.00) {
            view += " Excellent student.";
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            view += " Average student.";
        } else {
            view += " Very nice person.";
        }
        return view;
    }

    private void create(String[] command) {
        String name = command[1];
        int age = Integer.parseInt(command[2]);
        double grade = Double.parseDouble(command[3]);
        if (!repository.containsKey(name)) {
            var student = new Student(name, age, grade);
            repository.put(name, student);
        }
    }
}
