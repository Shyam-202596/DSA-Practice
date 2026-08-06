public class Patterns {
    public static void main(String[] args){

        pattern27(4);
    }

    static void pattern27(int n){
		int start = 1;
		for(int row = 0; row < n; row++){
			
			for(int blank = 0; blank < 2* row; blank++){
				System.out.print(" ");
			}
			
			for(int col = 0; col < n - row; col++){
				System.out.print(start + " ");
				start++;
			}
			
			System.out.println();
		}
	}
	
	static void pattern26(int n){
		int start = 1;
		for(int row = 0; row < n; row++){
			for(int col = 0; col < n - row; col++){
				System.out.print(start + " ");
			}
			start++;
			
			System.out.println();
		}
	}
	
	static void pattern25(int n){
		for(int row = 0; row < n; row++){
			
			for(int blank = 0; blank < n - 1 - row; blank++){
				System.out.print(" ");
			}
			
			int numberOfCo1s = row > 0 && row < n-1 ? 1 : n;
			for(int col = 0; col < numberOfCo1s; col++){
				System.out.print("*");
			}
			
			int spaces = row > 0 && row < n-1 ? n - 2 : 0;
			for(int blank = 0; blank < spaces; blank++){
				System.out.print(" ");
			}
			
			if(row > 0 && row < n-1){
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	static void pattern24(int n){
		for(int row = 0; row < 2*n; row++){
			System.out.print("*");
			
			int spaces1 = row > 0 && row < n ? row - 1 : (row >= n && row < 2*n - 1 ? 2*n - row - 2: 0);
			for(int blank = 0; blank < spaces1; blank++){
				System.out.print(" ");
			}
			if(row > 0 && row < 2*n-1){
				System.out.print("*");
			}
			
			int spaces2 = row < n ? 2*(n - row - 1) : 2*(row - n);
			for(int blank = 0; blank < spaces2; blank++){
				System.out.print(" ");
			}
			System.out.print("*");
			
			int spaces3 = row > 0 && row < n ? row - 1 : (row >= n && row < 2*n - 1 ? 2*n - row - 2: 0);
			for(int blank = 0; blank < spaces3; blank++){
				System.out.print(" ");
			}
			if(row > 0 && row < 2*n-1){
				System.out.print("*");
			}
			
			System.out.println();
		} 
	}
	
	//23. need improvement for more than 3, for 3 it is good, but for more than three it is not working fine.  
	static void pattern23(int n){
		for(int row = 0; row < n; row++){
			int spaces1 = n - row;
			for(int blank = 0; blank < spaces1; blank++){
				System.out.print(" ");
			}
			System.out.print("*");
			
			int spaces2 = row > 0 && row < n - 1 ? n - row : n + 1;
			for(int blank = 0; blank < spaces2; blank++){
				System.out.print(" ");
			}
			System.out.print("*");
			
			int spaces3 = row > 0 && row < n - 1 ? n - row - 1: (row != 0 ? n + 1: 0);
			for(int blank = 0; blank < spaces3; blank++){
				System.out.print(" ");
			}
			if(row > 0){
				System.out.print("*");
			} 
			
			int spaces4 = row > 0 && row < n - 1 ? n - row : 0;
			for(int blank = 0; blank < spaces4; blank++){
				System.out.print(" ");
			}
			if(row > 0 && row < n-1){
				System.out.print("*");
			}
			System.out.println();
		}
	} 
	
	//22 is Imp.
	static void pattern22(int n){
		for(int row = 0; row < n; row++){
			
			int start = row % 2 == 0 ? 1 : 0;
			
			for(int col = 0; col < row + 1; col++){
				System.out.print(start + " ");	
				start = 1 - start;
			}
			
			System.out.println();
		}
	} 

    static void pattern21(int n){
		int number = 1;
		for(int row = 0; row < n; row++){
			for(int col = 0; col < row + 1; col++){
				System.out.print(number + " ");
				number++;
			}
			System.out.println();
		}
	} 
	
	static void pattern20(int n){
		for(int row = 0; row < n; row++){
			
			int numberOfCol = row > 0 && row < n - 1 ? 1 : n-1;
			for(int col = 0; col < numberOfCol; col++){
				System.out.print("*");
			}
			
			int spaces = row > 0 && row < n - 1 ? n - 3 : 0;
			for(int blank = 0; blank < spaces; blank++){
				System.out.print(" ");
			}
			
			int numberOfCo1s = row > 0 && row < n - 1 ? 1 : 0;
			for(int col = 0; col < numberOfCo1s; col++){
				System.out.print("*");
			}
			System.out.println();
		}
	} 
	
	static void pattern19(int n){
		for(int row = 0; row < 2*n; row++){
			
			int numberOfCol = row < n ? row + 1 : 2 * n - row - 1;
			for(int col = 0; col < numberOfCol; col++){
				System.out.print("*");
			}
			
			int spaces = row < n ? 2 * (n - row - 1) : 2 * (row - n + 1);
			for(int blank = 0; blank < spaces; blank++){
				System.out.print(" ");
			}
			
			for(int col = 0; col < numberOfCol; col++){
				System.out.print("*");
			}
			
			System.out.println();
		}
	} 
	
	static void pattern18(int n){
		for(int row = 0; row < 2*n; row++){
			
			int numberOfCol = row < n ? n - row : row - n + 1;
			for(int col = 0; col < numberOfCol; col++){
				System.out.print("*");
			}
			
			int spaces = row < n ? 2 * row : 2 * (2 * n - row -1);
			for(int blank = 0; blank < spaces; blank++){
				System.out.print(" ");
			}
			
			int numberOfCol1 = row < n ? n - row : row - n + 1;
			for(int col = 0; col < numberOfCol1; col++){
				System.out.print("*");
			}
			System.out.println();
		}
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
