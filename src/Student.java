public record Student(String name, int age, int rollNo) {

    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Age: " + age;
    }
}