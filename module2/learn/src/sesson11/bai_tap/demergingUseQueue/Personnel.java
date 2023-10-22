package sesson11.bai_tap.demergingUseQueue;

public class Personnel{
    private String name;
    private String gender;
    private String born;
    public Personnel(){
    }
    public Personnel(String name, String gender, String born){
        this.name = name;
        this.gender = gender;
        this.born = born;
    }
    public Personnel(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }
    public String getFirstName(){
        String[] arr = this.getName().split(" ");
        return arr[arr.length-1];
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "name = " + name + ", gender = " + gender +
                ", born = " + born + '}';
    }
}
