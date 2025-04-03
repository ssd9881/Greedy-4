// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    
    public static int shortestWay(String source, String target)
    {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int s = source.length();
        int t = target.length();
        for(int i=0;i<s;i++){
            char c = source.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,new ArrayList<>());
            }
            map.get(c).add(i);
        }
        int sp=0; int tp=0;int count=0;
        while(tp<t){
          char tchar = target.charAt(tp);
          if(!map.containsKey(tchar)) return -1;
          List<Integer> li = map.get(tchar);
          int k= binarySearch(li,sp);
          if(k==li.size()){
              count++;
              sp=li.get(0);
          }else{
              sp=li.get(k);
          }
          tp++;
          sp++;
        }
        return count;
    }
    private static int binarySearch(List<Integer> li, int target){
        int low = 0; int high = li.size()-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(li.get(mid)==target){
                return mid;
            }else if(li.get(mid)<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking input from the user
        System.out.println("Enter source string: ");
        String source = scanner.nextLine();
        
        System.out.println("Enter target string: ");
        String target = scanner.nextLine();
        
        int result = shortestWay(source, target);
        System.out.println("Minimum number of times to form target: " + result);
        
        scanner.close();
    }
}