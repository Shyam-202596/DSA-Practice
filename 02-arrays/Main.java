public class Main {
    public static void main(String[] args) {
        //Q: store a roll number.
        int rollNumber = 11;
        System.out.println("Roll Number: " + rollNumber);

        //Q: store a person name.
        String name = "Shyam Sagar";
        System.out.println("Name: " + name);

        //Q: store 5 roll numbers.
        int rno1 = 11;
        int rno2 = 12;
        int rno3 = 13;
        int rno4 = 14;
        int rno5 = 15;
        System.out.println("Roll Numbers: " + rno1 + ", " + rno2 + ", " + rno3 + ", " + rno4 + ", " + rno5);

        //Syntax to create an array.
        // datatype[] variable_name = new datatype[size];
        // store 5 roll numbers.
        // int[] rollNumbers = new int[5];
        // or directly
        // int[] rollNumbers = {11,12,13,14,15};

        int[] rollNumbers; //declaration of array, rollNumber is getting created in stack memory.
        rollNumbers = new int[5]; //initialisation: creation of array, object is getting created in heap memory.
        System.out.println(rollNumbers[0]); //default value is 0 for int array.

        String[] arr = new String[5];
        System.out.println(arr[0]); //default value is null for String array.

        for(String elements : arr){
            System.out.print(elements + " ");
        }
    }
}
