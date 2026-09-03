import java.util.ArrayList;

public class FindIndex {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 4, 9};
		//int target = 3;
		//boolean ans = checkTarget(arr, target, 0);
        //System.out.println(ans);
        int target = 4;
		//int ans = findLastIndex(arr, target, arr.length - 1);
		//int ans = findIndex(arr, target, 0);
		//findAllIndex(arr, target, 0);
		//System.out.println(list);
        //System.out.println(ans);
        //System.out.println(findAllIndex(arr, target, 0, new ArrayList<>()));
        System.out.println(findAllIndex3(arr, target, 0));
	}
	static ArrayList<Integer> findAllIndex3(int[] arr, int target, int index){
	    ArrayList<Integer> list = new ArrayList<>();
	    if(index == arr.length){
	        return list;
	    }
	    if(arr[index] == target){
	        list.add(index);
	    }
	    ArrayList<Integer> ansFromBelowCalls = findAllIndex3(arr, target, index + 1);
	    list.addAll(ansFromBelowCalls);
	    return list;
	}
    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list){
	    if(index == arr.length){
	        return list;
	    }
	    if(arr[index] == target){
	        list.add(index);
	    }
	    return findAllIndex(arr, target, index + 1, list);
	}
	static ArrayList<Integer> list = new ArrayList<>();
	static void findAllIndex(int[] arr, int target, int index){
	    if(index == arr.length){
	        return;
	    }
	    if(arr[index] == target){
	        list.add(index);
	    }
	    findAllIndex(arr, target, index + 1);
	}
	static int findLastIndex(int[] arr, int target, int index){
	    if(index == -1){
	        return -1;
	    }
	    if(arr[index] == target){
	        return index;
	    }else{
	        return findIndex(arr, target, index - 1);
	    }
	}
	static int findIndex(int[] arr, int target, int index){
	    if(index == arr.length){
	        return -1;
	    }
	    if(arr[index] == target){
	        return index;
	    }else{
	        return findIndex(arr, target, index + 1);
	    }
	}
	static boolean checkTarget(int[] arr, int target, int index){
	    if(index == arr.length){
	        return false;
	    }
	    return arr[index] == target || checkTarget(arr, target, index + 1);
    }
}
