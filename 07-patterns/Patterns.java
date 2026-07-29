public class Patterns {
    public static void main(String[] args){

        pattern13(5);
    }

    static void pattern13(int n){
        for(int row = 0; row < n; row++){
            int spaces = n - 1 - row;
            for(int blank = 0; blank < spaces; blank++){
                System.out.print(" ");
            }
            int numberOfCol = row < n - 1 ? 1 : 2 * row + 1;
            for(int col = 0; col < numberOfCol; col++){
                System.out.print("*");
            }
            int spaces2 = row > 0 && row < n-1 ? 2 * row - 1 : 0;
            for(int blank = 0; blank < spaces2; blank++){
                System.out.print(" ");
            }
            int numberOfCol2 = row > 0 && row < n - 1 ? 1 : 0;
            for(int col = 0; col < numberOfCol2; col++){
                System.out.print("*");
            }

            System.out.println();
        }
    }

    static void pattern12(int n){
        for(int row = 0; row < 2 * n; row++){
            int spaces = row < n ? row : 2 * n - 1 - row;
            for(int blank = 0; blank < spaces; blank++){
                System.out.print(" ");
            }
            int numberOfCol = row < n ? n - row : row - n + 1;
            for(int col = 0; col < numberOfCol; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern11(int n){
        for(int row = 0; row < n; row++){
            int spaces = row;
            for(int blank = 0; blank < spaces; blank++){
                System.out.print(" ");
            }
            int numberOfCol = n - row;
            for(int col = 0; col < numberOfCol; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern10(int n){
        for(int row = 0; row < n; row++){
            int spaces = n - 1 - row;
            for(int blank = 0; blank < spaces; blank++){
                System.out.print(" ");
            }
            int numberOfCol = row + 1;
            for(int col = 0; col < numberOfCol; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern9(int n){
        for(int row = 5; row > 0; row--){
            int spaces = n - row;
            for(int blank = 0; blank < spaces; blank++){
                System.out.print(" ");
            }
            int numberOfCol = 2 * row - 1;
            for(int col = 0; col < numberOfCol; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern8(int n){
        for(int row = 0; row < n; row++){
            int spaces = n - 1 - row;
            for(int blank = 0; blank < spaces; blank++){
                System.out.print(" ");
            }
            int numberOfCol = 2 * row + 1;
            for(int col = 0; col < numberOfCol; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern7(int n){
        for(int row = 0; row < n; row++){
            int spaces = row;
            for(int blank = 0; blank < spaces; blank++){
                System.out.print(" ");
            }
            int numberOfCol = n - row;
            for(int col = 0; col < numberOfCol; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern6(int n){
        for(int row = 1; row <= n; row++){
            int spaces = n - row;
            for(int blank = 0; blank < spaces; blank++){
                System.out.print(" ");
            }
            int numberOfCol = row;
            for(int col = 0; col < numberOfCol; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern5(int n){
        for(int row = 1; row < 2 * n; row++){
            int numberOfCol = row < n + 1 ? row : 2 * n - row;
            for(int col = 0; col < numberOfCol; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern4(int n){
        for(int row = 0; row < n; row++){
            int numberOfCol = row + 1;
            for(int col = 1; col <= numberOfCol; col++){
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n){
        for(int row = 0; row < n; row++){
            int numberOfCol = n - row;
            for(int col = 0; col < numberOfCol; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern2(int n){
        for(int row = 0; row < n; row++){
            int numberOfCol = row + 1;
            for(int col = 0; col < numberOfCol; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern1(int n){
        for(int row = 0; row < n; row++){
            int numberOfCol = n;
            for(int col = 0; col < numberOfCol; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
