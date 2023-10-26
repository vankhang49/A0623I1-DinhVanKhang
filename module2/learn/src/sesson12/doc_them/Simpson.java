package sesson12.doc_them;

public class Simpson implements Comparable<Simpson>{
    String name;

    Simpson(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Simpson simpson) {
        return this.name.compareTo(simpson.name);
    }

    @Override
    public String toString() {
        return name;
    }
}

