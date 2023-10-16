package sesson10.bai_tap.arrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<>();
        listInteger.add(7);
        listInteger.add(6);
        listInteger.add(4);
        listInteger.add(3);
        listInteger.add(2);
        listInteger.add(1);
        listInteger.add(4,5);

        System.out.println("element 1: "+listInteger.get(0));
        System.out.println("element 2: "+listInteger.get(1));
        System.out.println("element 3: "+listInteger.get(2));
        System.out.println("element 4: "+listInteger.get(3));
        System.out.println("element 5: "+listInteger.get(4));
        System.out.println("element 6: "+listInteger.get(5));
        System.out.println("element 7: "+listInteger.get(6));

        System.out.println(listInteger.contains(4));
        MyList<Integer> newList = listInteger.clone();
        System.out.println(newList);

        listInteger.clear();
        System.out.println(listInteger.get(0));
    }
}
