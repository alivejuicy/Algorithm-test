import java.util.*;

class Solution {
    //n미터 벽
    //m미터의 롤러 길이
    //section 칠할 구역 번호
//     static int[] arr;
//     static boolean[] visit;
//     static count;
//     static Queue<Integer> q = new ArrayDeque<>();
//     public int solution(int n, int m, int[] section) {
//         int answer = 0;
//         arr = new int[m+1]; //1부터 m까지
//         visit = new boolean[m+1]; // 1부터 m까지
//         for(int i : section){
//             visit[i] = true; //칠해져있는곳 방문처리해주고
//         }
        
//         q.offer(section[0]);
//         bfs();
//         return answer;
//     }
//     public void bfs(int start){
//         visit[start] = true; //방문처리하고
//         while(!q.isEmpty()){ //큐 빌때까지
//             int a = q.poll();
            
//             for(int i = 0; i<2; i++){
                
//             }
//         }
//     }
    
    //탐색이 아닌 그리디로 가능했음.
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int target = section[0]; //첫 구역을 m만큼 미리 칠하고 target에 담음
        answer++;
        
        for(int i : section) {
            if(target+m > i) continue;  //칠해야할곳이 이미 칠해져있다면 넘어가고  
            
            target = i;
            answer++; //아니면 칠하고 구역 업뎃
        }
        
        return answer;
    }
}