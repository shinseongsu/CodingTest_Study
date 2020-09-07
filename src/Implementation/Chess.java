package Implementation;

/*
*
* 왕실의 나이트
*
* 행복 왕국의 왕실 정원은 체스판과 같은 8 X 8 좌표 평면이다.
* 왕실 정원의 특정한 한 칸에 나이트가 서 있다. 나이트는 매우 충성스러운 신하로서 매일 무술을 연마한다.
*
* 나이트는 말을 타고 있기 때문에 이동을 할 때는 L자 형태로만 이동할 수 있으며 정원 밖으로는 나갈 수 없다.
* 나이트는 특정한 위치에서 다음과 같은 2가지 경우로 이동할 수 있다.
*
* 1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
* 2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기
*
* 왕실의 정원에서 행 위치를 표현할 때는 1부터 8로 표현하며, 열 위치를 표현할 때는 a부터 h로 표현한다.
*
* 예를 들어 나이트가 a1 에 있을 때 이동할 수 있는 경우의 수는 다음 2가지이다.
* a1의 위치는 좌표 평면에서 구석의 위치에 해당하며 나이트는 정원의 밖으로는 나갈 수 없기 때문이다.
*
* 1. 오른쪽 두칸 이동후 아래칸 한칸 이동하기 C2
* 2. 아래로 두칸 이동후 오른쪽 한칸 이동하기 b3
*
*
* 이처럼 나이트의 위치가 주어졌을 때 나이트가 이동할 수 있는 경우의 수를 출력하는 프로그램을 작성하시오.
*
 */
public class Chess {

    public static void main(String[] args) {

        String input = "a1";

        int result = solution(input);

        System.out.println(result);

    }

    /*
    *
    * @param String input 입력 받은 위치 값
    *
    * @return int count   이동할 수 있는 방법 수
    *
     */
    private static int solution(String input) {

        int count = 0;

        int row = input.charAt(0) - 'a' + 1;
        int column = input.charAt(1) - '0';

        // 나이트가 이동할 수 있는 8가지 방향 정의
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        for (int i = 0; i < 8; i++) {
            int nextRow = row + dx[i];
            int nextColumn = column + dy[i];
            // 해당 위치로 이동이 가능하다면 카운트 증가
            if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
                count += 1;
            }
        }
        return count;
    }


}
