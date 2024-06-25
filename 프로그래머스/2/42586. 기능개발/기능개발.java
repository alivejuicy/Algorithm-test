import java.util.*;

class Solution {
    private List<Integer> al;
    private Stack<Integer> sk;
    private Queue<Integer> dq;
    
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        
        al = new ArrayList<>();
        dq = new ArrayDeque<>();
        //sk = new Stack<>();
        
        //1. 배포일 먼저 구함
        for(int i = 0; i < progresses.length; i++){
            int progress = progresses[i];
            int buildDay = 0;
            
            while(progress < 100){
                progress += speeds[i];
                buildDay++;
            }
            dq.offer(buildDay);
        }
        
        while (!dq.isEmpty()) {
            int currentDay = dq.poll();
            int cnt = 1;
            
            while (!dq.isEmpty() && dq.peek() <= currentDay) {
                dq.poll();
                cnt++;
            }
            
            al.add(cnt);
        }
//         if(dq.size() == 1) {return new int[]{1};} // 요소 1개면 1개 리턴
        
//         sk.push(dq.poll()); // 맨 처음 배포 제품은 기본으로 넣고
//         while(!dq.isEmpty()){
           
//            //7, 3, 9
//            //5, 10, 1, 1, 20, 1
//             if(sk.peek() >= dq.peek()){ // 배포일이 앞선 제품보다 빠르다면
//                 sk.push(dq.poll());  // 스택에 담아 대기
//             }
//             else{
//                 al.add(sk.size()); // 제품 개수 담기
//                 sk.clear();
//                 sk.push(dq.poll()); // 다음 제품 배포일 담기
//             }
//         }
        
//         if(!sk.isEmpty()) al.add(sk.size()); //남아있는 배포 제품 일자       
        
        answer = al.stream().mapToInt(i->i).toArray();
        return answer;
    }
}