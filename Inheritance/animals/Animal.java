package animals;

public abstract class Animal{
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!name.isEmpty() && name != null) {
        this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    protected abstract String produceSound();

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(!gender.isEmpty() && gender != null) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(26);

        sb.append(this.getClass().getSimpleName());
        sb.append("\r");
        sb.append("\n");

        sb.append(name);
        sb.append(' ');
        sb.append(age);
        sb.append(' ');
        sb.append(gender);
        sb.append("\r");
        sb.append("\n");

        sb.append(this.produceSound());

        return sb.toString();
    }

}
