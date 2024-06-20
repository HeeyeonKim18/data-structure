package coding.interview.array;

import java.util.ArrayList;

public class MyList {
    ArrayList<Integer> list;
    public MyList() {
        list = new ArrayList<>();
    }

    public int get(int index){
        return list.get(index);
    }

    public int add(int item){
        list.add(item);
        return list.size();
    }

    public int removeTheLast(){
        return list.remove(list.size() - 1);
    }

    public int remove(int index){
        return list.remove(index);
    }
    public static void main(String[] args) {
        MyList array = new MyList();
        System.out.println("array.add(1) = " + array.add(1));
        System.out.println("array.add(2) = " + array.add(2));
        System.out.println("array.get(0) = " + array.get(0));
        System.out.println("array.removeTheLast() = " + array.removeTheLast());
        System.out.println("array.remove(0) = " + array.remove(0));

    }

}
