class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int target=-1;
        for(int i=0;i<tops.length;i++){
            int tp = tops[i];
            map.put(tp,map.getOrDefault(tp,0)+1);
            if(map.get(tp)>=tops.length){
                target=tp;
                break;
            }
            int tb = bottoms[i];
            map.put(tb, map.getOrDefault(tb, 0) + 1);
            if(map.get(tp)>=tops.length){
                target=tp;
                break;
            }
        }
        if(target ==-1) return -1;
        int trot=0; int brot=0;
         for(int i=0;i<tops.length;i++){
            if(tops[i]!=target&&bottoms[i]!=target){
                return -1;
            }
            if(tops[i]!=target){
                trot++;
            }
            if(bottoms[i]!=target){
                brot++;
            }
         }

         return Math.min(brot,trot);
    }
}