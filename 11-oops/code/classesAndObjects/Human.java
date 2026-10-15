public class Human {
    public static void main(String[] args) {
        // Create an instance of the Human class
        Human human = new Human();

        // Call the methods of the Human class
        human.eat();
        human.sleep();
        human.walk();
    }
    // Method to simulate eating
    public void eat() {
        System.out.println("The human is eating."); 
    }
    // Method to simulate sleeping
    public void sleep() {
        System.out.println("The human is sleeping.");   
    }
    // Method to simulate walking
    public void walk() {
        System.out.println("The human is walking.");
    }
}
