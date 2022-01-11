package java_solution;
/*
[로또의 최고 순위와 최저 순위]
https://programmers.co.kr/learn/courses/30/lessons/77484?language=java

*/

import java.io.IOException;

public class lotto_best_worst_rank {
    
    public static void main(String[] args) throws IOException {
		
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        
        Solution s = new Solution();
        int[] ans = s.Sol(lottos,win_nums);
        for (int i : ans) {
            System.out.println(i);    
        }
        
    }
}

class Solution {
   public int[] Sol(int[] lottos, int[]win_nums){
    
    
    int best = 0;
    int worst = 0;
    
    /*
    //어차피 여섯갠데 뭐하러 정렬을해..
    Integer[] lottos_i = Arrays.stream(lottos).boxed().toArray(Integer[]::new); // 
    Integer[] win_nums_i = Arrays.stream(win_nums).boxed().toArray(Integer[]::new); // 
    Arrays.sort(lottos_i,Collections.reverseOrder());   //44 31 25 1 0 0
    Arrays.sort(win_nums_i,Collections.reverseOrder()); // 45 31 19 10 6 1
    for(int i=0;i<lottos_i.length;i++){
         System.out.println(lottos_i[i]);        
    }
    // for(int i=0;i<win_nums_i.length;i++){
    //     System.out.println(win_nums_i[i]);        
    // }
    */
    int count = 0;
    for(int i = 0;i<lottos.length;i++){
        if(lottos[i] == 0) {
            count++;
            continue;
        }
        for(int j =0;j<win_nums.length;j++){
            if(lottos[i] == win_nums[j])
                best++;
        }
    }

    worst = 7-best;
    worst = worst == 7 ? 6 : worst;
    best = 7-(best+count);

    best = best == 7? 6 : best;
    
    int[] answer = new int[] {best,worst};
    return answer;
    
   }
}