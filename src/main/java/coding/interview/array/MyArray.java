package coding.interview.array;

public class MyArray {
    int[] arr;
    public MyArray() {
        arr = new int[10];
    }

    public int get(int index){
        return arr[index];
    }

    public int add(int item){
        int length  = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == 0) {
                arr[i] = item;
                length = i;
                break;
            }
        }
        return length + 1;
    }

    public int removeTheLast(){
        int value  = 0;
        for (int i = arr.length - 1 ; i >= 0; i--){
            if(arr[i] != 0) {
                value = arr[i];
                arr[i] = 0;
                break;
            }
        }
        return value;
    }

    public int remove(int index){
        int value = arr[index];
        shiftItems(index);
        return value;
    }

    private void shiftItems(int index) {
        arr[index] = 0;
        for (int i = index + 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
            arr[i] = 0;
        }

    }

    public static void main(String[] args) {
        MyArray arr = new MyArray();
        System.out.println("array.add(1) = " + arr.add(1));
        System.out.println("array.add(2) = " + arr.add(2));
        System.out.println("array.add(2) = " + arr.add(3));
        System.out.println("array.get(0) = " + arr.get(0));
        System.out.println("array.removeTheLast() = " + arr.removeTheLast());
        System.out.println("array.remove(0) = " + arr.remove(0));

        for (int i = 0; i < arr.arr.length; i++) {
            System.out.println("arr.arr[i] = " + arr.arr[i]);
        }
    }

}
