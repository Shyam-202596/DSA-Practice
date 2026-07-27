public class MaxWealth {
    public static void main(String[] args) {
        int[][] accounts = {
                {2,8,7},
                {7,1,3},
                {1,9,5}
        };
        int ans = maximumWealth(accounts);
        System.out.println(ans);
    }

    private static int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        for(int[] person: accounts){
            int sum = 0;
            for(int money: person){
                sum = sum + money;
            }
            if(sum>ans){
                ans = sum;
            }
        }
        return ans;
    }

}
