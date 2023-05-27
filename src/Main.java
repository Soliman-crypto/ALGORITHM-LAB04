public class Main {
    public static void main(String[] args) {
        DYNAMICARRAY DYNAMICARRAY = new DYNAMICARRAY();


        DYNAMICARRAY.add(10);
        DYNAMICARRAY.add(20);
        DYNAMICARRAY.add(30);
        DYNAMICARRAY.add(40);
        DYNAMICARRAY.add(50);

        System.out.println("Size: " + DYNAMICARRAY.getSize());

        System.out.println("Element at index 2: " + DYNAMICARRAY.get(2));

        DYNAMICARRAY.set(2, 25);
        System.out.println("Element at index 2 after modification: " + DYNAMICARRAY.get(2));

        System.out.println("Max element: " + DYNAMICARRAY.getMax());

        DYNAMICARRAY.remove(2);
        System.out.println("Size after removal: " + DYNAMICARRAY.getSize());

        System.out.println("Max element after removal: " + DYNAMICARRAY.getMax());
        System.out.println("Second max element after removal: " + DYNAMICARRAY.getSecondMax());

        for (int value : DYNAMICARRAY) {
            System.out.println(value);
        }
    }
}