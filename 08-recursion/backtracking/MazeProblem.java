public class MazeProblem {
    public static void main(String[] args) throws java.lang.Exception {
        System.out.println(count(0, 0));
        path("", 0, 0);
        System.out.println(pathRet("", 0, 0));
    }
    static int count(int r, int c){
        if(r == 2 || c == 2){
            return 1;
        }
        int left = count(r + 1, c);
        int right = count(r, c + 1);
        return left + right;
    } 
    static void path(String p, int r, int c){
        if(r == 2 && c == 2){
            System.out.println(p);
            return;
        }
        if(r < 2){
            path(p + 'D', r + 1, c);
        }
        if( c < 2){
            path(p + 'R', r, c + 1);
        }
    }
static ArrayList<String> pathRet(String p, int r, int c){
        if(r == 2 && c == 2){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(r < 2){
            ans.addAll(pathRet(p + 'D', r + 1, c));
        }
        if( c < 2){
            ans.addAll(pathRet(p + 'R', r, c + 1));
        }
        return ans;
    }
}
