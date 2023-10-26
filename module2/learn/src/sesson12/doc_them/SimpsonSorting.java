package sesson12.doc_them;

import java.util.*;

public class SimpsonSorting{
    public static void main(String[] args) {
//        Sắp xếp danh sách Java với một đối tượng tùy chỉnh
        List<Simpson> simpsons = new ArrayList<>();
        simpsons.add(new Simpson("Homer "));
        simpsons.add(new Simpson("Marge "));
        simpsons.add(new Simpson("Bart "));
        simpsons.add(new Simpson("Lisa "));

        Collections.sort(simpsons);
        for (Simpson item: simpsons){
            System.out.print(item + " ");
        }
        System.out.println();
        Collections.reverse(simpsons);
        for (Simpson item: simpsons){
            System.out.print(item + " ");
        }
        System.out.println();

//        Sắp xếp đối với mảng trong Java
        int[] moesPints = new int[] {9, 8, 7, 6, 1};

        Arrays.sort(moesPints);
        for (int i : moesPints){
            System.out.print(i + " ");
        }
        System.out.println();
        Simpson[] simpsons2 = new Simpson[]{new Simpson("Lisa"), new Simpson("Homer")};

        Arrays.sort(simpsons2);
        for (Simpson item: simpsons2){
            System.out.print(item + " ");
        }
        System.out.println();

//        Sắp xếp một Map với TreeMap
        Map<Simpson, String> simpsons3 = new TreeMap<>();
        simpsons3.put(new Simpson("Moe"), "shotgun");
        simpsons3.put(new Simpson("Lenny"), "Carl");
        simpsons3.put(new Simpson("Homer"), "television");
        simpsons3.put(new Simpson("Barney"), "beer");

        System.out.println(simpsons3);

//        Sắp xếp một Set với TreeSet
        Set<Simpson> simpsons4 = new TreeSet<>();
        simpsons4.add(new Simpson("Moe"));
        simpsons4.add(new Simpson("Lenny"));
        simpsons4.add(new Simpson("Homer"));
        simpsons4.add(new Simpson("Barney"));

        System.out.println(simpsons4);

//        Sắp xếp với Comparator
        List<Simpson> characters = new ArrayList<>();

        Simpson homer = new Simpson("Homer");
        Simpson moe = new Simpson("Moe");

        characters.add(homer);
        characters.add(moe);

        characters.sort((Comparator.<Simpson>
                        comparingInt(character1 -> character1.name.length())
                .thenComparingInt(character2 -> character2.name.length())));

        System.out.println(characters);
    }
}
