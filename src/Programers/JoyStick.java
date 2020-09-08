package Programers;

/*
*
* 조이스틱
*
* 조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
* ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
*
* 조이스틱을 각 방향으로 움직이면 아래와 같습니다.
*
* ▲ - 다음 알파벳
* ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
* ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
* ▶ - 커서를 오른쪽으로 이동
*
*
* 예를 들어 아래의 방법으로 JAZ를 만들 수 있습니다.
*
* - 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
* - 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
* - 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
* 따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
*
* 만들고자 하는 이름 name이 매개변수로 주어질 때,
* 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
*
*
* name	return
* JEROEN	56
*  JAN   	23
*
 */
public class JoyStick {

    public static void main(String[] args) {

        String name = "JEROEN";

        int result = solution(name);

        System.out.println(result);
    }

    /*
    *
    * 내가 생각한 알고리즘
    *
     */
    private static int solution(String name) {
        int answer = 0;

        String names = "";
        for(int i = 0 ; i < name.length() ; i++) {
            names += "A";
        }
        int location = 0;
        int direction = 1;  // 양수이면 오른쪽  음수이면 왼쪽

        if( names.equals(name) ) {  // 같아지면 끝
            return 0;
        }

        // 방향 정하기
        while(true) {
            if(name.charAt(location + direction) != 'A') {
                direction = 1;
                break;
            } else if (name.charAt(name.length() - direction ) != 'A' ) {
                direction = -1;
                break;
            } else {
                direction++;
            }
        }

        while(true) {

            int MoveStick = Math.min(  name.charAt(location) - names.charAt(location) , 'Z' - name.charAt(location) +1 );

            answer = answer +  MoveStick;

            names = names.substring(0, location) + name.charAt(location) + names.substring(location+1, names.length());

            if( names.equals(name) ) {  // 같아지면 끝
                break;
            }

            answer++;
            location += direction;
            if(location == -1) {
                location = names.length() - 1;
            }
        }
        return answer;
    }

    public static int solution1(String name) {
        // 1. 위, 아래 최소 이동
        int ans = 0;
        for(int i = 0 ; i < name.length() ; i++) {
            if(name.charAt(i)!= 'A') {
                int up = name.charAt(i) - 'A';
                int down = 1 + 'Z' - name.charAt(i);
                ans += (up < down)? up : down;
            }
        }

        // 2. A 아닌 모든 문자를 들릴 수 있는 최소 좌우 이동
        // 모든 위치에서 역으로 돌아가는 경우 최소를 찾는다.
        int minMove = name.length() - 1;
        for(int i = 0 ; i < name.length() ; i++) {
            if(name.charAt(i) != 'A') {
                int next = i+1;
                while(next < name.length() && name.charAt(next) == 'A') {
                    next++;
                }
                int move = 2 * i + name.length() - next;
                minMove = Math.min(move, minMove);
            }
        }

        return ans + minMove;
    }

}
