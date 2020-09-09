package Programers;

import java.util.*;
import java.util.stream.Collectors;

/*
*
* 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다.
* 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
*
* 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
* 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
* 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
*
* 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
* 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
*
* genres	                                  plays	                        return
* [classic, pop, classic, classic, pop] 	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
*
 */
public class BestAlbum {

    public static void main(String[] args) {
        String[] genres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };

        int[] result = solution1(genres, plays);

        for(int i = 0 ; i < result.length ; i++) {
            System.out.print(result[i] + ",");
        }


    }

    // 내가 푼 방식
    private static int[] solution(String[] genres, int[] plays) {
        int[] answer = new int[genres.length-1];
        int index= 0;

        Map<String, Integer> map = new HashMap<>();

        // 장르별 플레이 횟수 계산
        for(int i = 0 ; i < genres.length ; i++) {
            if(map.containsKey(genres[i])) {
                map.put(genres[i], map.get(genres[i]) + plays[i]);
            } else {
                map.put(genres[i], plays[i]);
            }
        }

        // 앨범 넣기
        while(!map.isEmpty()) {

            // 속한 노래중 가장 많은 거 선택
            int max = 0;
            String maxGenre = "";
            for(String genre : map.keySet() ) {
                if(max < map.get(genre)) {
                    max = map.get(genre);
                    maxGenre = genre;
                }
            }
            map.remove(maxGenre);

            // 장르 내 많이 재생된, 고유 번호 순서대로
            List<Integer> list = new ArrayList<>();

            for(int i = 0 ; i < genres.length ; i++) {
                if(genres[i].equals(maxGenre)) {
                    list.add(i);
                }
            }

            while(!list.isEmpty()) {

                int maxValue = 0;
                int maxIndex = 0;
                int list_index = 0;

                for(int i = 0 ; i < list.size() ; i++) {
                    if(maxValue < plays[list.get(i)]) {
                        maxValue = plays[list.get(i)];
                        maxIndex = list.get(i);
                        list_index = i;
                    }
                }
                list.remove(list_index);

                if(index < answer.length) {
                    answer[index++] = maxIndex;
                }
            }

        }

        return answer;
    }

    // 인터넷에 다른 풀이 방법
    public static int[] solution1(String[] genres, int[] plays) {

        HashMap<String, Integer> g1 = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            g1.put(genres[i], g1.getOrDefault(genres[i], 0) + plays[i]);
        }

        TreeMap<Integer, String> g2 = new TreeMap<>(Collections.reverseOrder());

        g1.forEach((k, v) -> g2.put(v, k));

        ArrayList<Integer> answer2 = new ArrayList<>();

        // 여기 for문에서는 가장 많이 나오는 장르부터 돈다
        for (String genre : g2.values()) {
            ArrayList<Integer> temp = new ArrayList<>();    // 장르에 해당하는 곡 번호가 담김
            for (int i = 0; i < genres.length; i++) {
                if (!genres[i].equals(genre)) continue;

                temp.add(i);
            }

            Collections.sort(temp, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (plays[o1] == plays[o2]) {
                        return Integer.compare(o1, o2);
                    }
                    else {
                        return Integer.compare(plays[o2], plays[o1]);
                    }
                }
            });
            answer2.add(temp.get(0));
            if (temp.size() > 1) {
                answer2.add(temp.get(1));
            }
        }

        int[] answer = new int[answer2.size()];
        for (int i = 0; i < answer2.size(); i++) {
            answer[i] = answer2.get(i);
        }

        return answer;
    }

}
