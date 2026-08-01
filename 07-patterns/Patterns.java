public class Patterns {
    public static void main(String[] args){

        pattern17(5);
    }

    //17 is Imp.
	static void pattern17(int n){
		for(int row = 0; row < 2*n-1; row++){
			int currentRow = row < n ? row + 1 : 2*n - row - 1;
			int spaces = n - currentRow;
			for(int blank = 0; blank < spaces; blank++){
				System.out.print(" ");
			}
			for(int col = currentRow; col > 0; col--){
				System.out.print(col);
			}
			for(int col = 2; col <= currentRow; col++){
				System.out.print(col);
			}
			System.out.println();
		}
	} 
	
	//16 is Imp.
	static void pattern16(int n){
		for(int row = 0; row < n; row++){
			int spaces = n - row - 1;
			for(int blank = 0; blank < spaces; blank++){
				System.out.print(" ");
			}
			int numberOfCol = row + 1;
			int value = 1;
			for(int col = 0; col < numberOfCol; col++){
				System.out.print(value + " ");
				value = value*(row - col) / (col + 1);
			}
			System.out.println();
		}
	}
	
	//15 is Imp.
	static void pattern15(int n){
		for(int row = 0; row < 2*n - 1; row++){
			int spaces = row < n ? n - row - 1 : row - n + 1;
			for(int blank = 0; blank < spaces; blank++){
				System.out.print(" ");
			}
			int numberOfCol = 1;
			for(int col = 0; col < numberOfCol; col++){
				System.out.print("*");
			}
			int spaces2 = row > 0 && row < 2*n - 2 && row < n ? 2*row - 1 : 2*(2*n - row - 2) - 1;
			for(int blank = 0; blank < spaces2; blank++){
				System.out.print(" ");
			}
			int numberOfCol2 = row > 0 && row < 2*n - 2 ? 1 : 0;
			for(int col = 0; col < numberOfCol2; col++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void pattern14(int n){
		for(int row = 0; row < n; row++){
			int spaces = row;
			for(int blank = 0; blank < spaces; blank++){
				System.out.print(" ");
			}
			int numberOfCol = row > 0 ? 1 : 2 * n - 1;
			for(int col = 0; col < numberOfCol; col++){
				System.out.print("*");
			}
			int spaces2 = row > 0 && row < n-1 ? n - 2*row + 2 : 0;
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
