package caseStudy.models;

public class test {
    public static void main(String[] args) {
        Villa villa1 = new Villa("Stay Villa", 100, 50, 4,
                "One Day", "5 stars", 7, 2) ;
        Villa villa2 = new Villa("Stay Villa", 70, 30, 4,
                "One Day", "3 stars", 5, 2) ;
        House house = new House("HomeStay", 40, 500, 2
                , "One Week", "3 Stars", 1);
        Room room = new Room("Love Room", 25, 25, 2,
                "One night", "Free 1 condom");
        System.out.println(villa1.infoOfService());
        System.out.println();
        System.out.println(villa2.infoOfService());
        System.out.println();
        System.out.println(house.infoOfService());
        System.out.println();
        System.out.println(room.infoOfService());
    }
}
