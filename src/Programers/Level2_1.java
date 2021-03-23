package Programers;

public class Level2_1 {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};

        int[] result = solution(prices);
        for(int i : result) {
            System.out.println(i);
        }

    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0 ; i < prices.length ; i++) {
            int base = prices[i];
            int count = 0;

            for(int j = i ; j < prices.length-1 ; j++) {
                if(base <= prices[j]) {
                    count++;
                } else {
                   break;
                }
            }
            answer[i] = count;
        }


        return answer;
    }

}
