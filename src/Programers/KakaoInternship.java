package Programers;

// 1	매우 비동의   - 3
// 2	비동의       - 2
// 3	약간 비동의   - 1
// 4	모르겠음      - 0
// 5	약간 동의     - 1
// 6	동의         - 2
// 7	매우 동의     - 3

//    1번 지표	라이언형(R), 튜브형(T)
//    2번 지표	콘형(C), 프로도형(F)
//    3번 지표	제이지형(J), 무지형(M)
//    4번 지표	어피치형(A), 네오형(N)

import java.util.HashMap;
import java.util.Map;

// ["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	"TCMA"
// ["TR", "RT", "TR"]	            [7, 1, 3]	    "RCJA"
public class KakaoInternship {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> scoreMap = new HashMap<>();

        for(int i = 0 ; i < survey.length ; i++) {
            String[] splitArr = survey[i].split("");
            int number = choices[i];

            if(number == 4) {
                continue;
            }

            if(number <= 3) {
                scoreMap.put(splitArr[0], scoreMap.getOrDefault(splitArr[0],0)  + 4 - number );
            } else {
                scoreMap.put(splitArr[1], scoreMap.getOrDefault(splitArr[1],0)  + number - 4 );
            }
        }

        StringBuilder result = new StringBuilder();
        if(scoreMap.getOrDefault("R", 0) >= scoreMap.getOrDefault("T", 0)) {
            result.append("R");
        } else {
            result.append("T");
        }

        if(scoreMap.getOrDefault("C", 0) >= scoreMap.getOrDefault("F", 0)) {
            result.append("C");
        } else {
            result.append("F");
        }

        if(scoreMap.getOrDefault("J", 0) >= scoreMap.getOrDefault("M", 0)) {
            result.append("J");
        } else {
            result.append("M");
        }

        if(scoreMap.getOrDefault("A", 0) >= scoreMap.getOrDefault("N", 0)) {
            result.append("A");
        } else {
            result.append("N");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        KakaoInternship kakaoInternship = new KakaoInternship();

        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        System.out.println(kakaoInternship.solution(survey, choices));
    }
}
