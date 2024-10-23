package CollectionFrameWorks;

import java.util.*;

public class BasicsList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(1);
        list.add(1);
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(2, 11);
        list.add(7);
        System.out.println(list);
        System.out.println(list.size());
        list.remove(Integer.valueOf(5));
        System.out.println(list);
        list.remove(2);
        System.out.println(list);

        System.out.println(list.contains(7));

        System.out.println(list.get(0));

        System.out.println(list.set(0, 9));
        System.out.println(list);

        // Iterator ??

        Iterator<Integer> itr = list.iterator();
        ListIterator<Integer> itr1 = list.listIterator();

        System.out.println("My List -->");
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("My New List -->");

        while (itr1.hasNext()) {
            System.out.println(itr1.next());
            if (itr1.hasPrevious()) {
                System.out.println(itr1.previous());
                break;
            }
        }

        // Sorting Using Comparator ???

        list.sort(new Comparator<Integer>() {
            public int compare(Integer A, Integer B) {
                return B - A;
            }
        });

        List<Student> list1 = new ArrayList<>();
        list1.add(new Student(10, "shashwat"));
        list1.add(new Student(5, "Ayush"));
        list1.add(new Student(15, "Pavleen"));
        list1.add(new Student(15, "Aashray"));

        list1.sort(new Comparator<Student>() {
            public int compare(Student A, Student B) {

                int res = B.rollNumber - A.rollNumber;
                if (res == 0) {
                    return B.name.compareTo(A.name);
                }
                return res;
            }
        });
    }
}

class Student {
    int rollNumber;
    String name;

    public Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public String toString() {
        return name;
    }

}