public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String ... name) {

        //this.name = name;
    }

    public int getAge() {
        setName("awe", "wae", "awe");
        return age;
    }

    public void setAge(int age) {
        String a;

        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
