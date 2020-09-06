package Implementation;


/*
*
* 상하좌우
*
* 여행가 A는 N X M 크기의 정사각형 공간 위에 서 있다.
* 이 공간은 1 X 1 크기의 정사각형으로 나누어져 있다.
* 가장 왼쪽 위 좌표는 (1,1)이며, 가장 오른 아래 좌표는 (N, N) 에 해당한다.쪽
*
* 여행사 A는 상, 하, 좌, 우 방향으로 이동할 수 있으며, 시작 좌표는 항상 (1,1)이다.
* 우리 앞에서는 여행가 A가 이동할 계획이 적힌 계획서가 놓여 있다.
*
* 계획서에는 하나의 줄에 띄어쓰기를 기준으로 하여 L, R, U, D중 하나의 문자가 반복적으로 적혀 있다.
*
*
 */
public class UpDownLeftRight {

    public static void main(String[] args) {

        int N = 5;
        char[] moves = {'R', 'R', 'R', 'U', 'D', 'D'};

        int[] result = solution(N, moves);

        System.out.println(result[0] + " , " + result[1]);

    }

    /*
    *
    * @param int N  가로,세로 크기
    * @param char[] 움직여야 할 방향
    *
    * @return 이동후 location
    *
    *
     */
    private static int[] solution(int N, char[] moves) {

        int[] location = {1, 1};

        for(int i = 0 ; i < moves.length ; i++) {

            switch(moves[i]) {
                case 'R':
                    if(location[1] == N) {
                        break;
                    } else {
                        location[1] = location[1] + 1;
                    }
                    break;
                case 'L':
                    if(location[1] == 1) {
                        break;
                    } else {
                        location[1] = location[1] - 1;
                    }
                    break;
                case 'U':
                    if(location[0] == 1) {
                        break;
                    } else {
                        location[0] = location[0] - 1;
                    }
                    break;
                case 'D':
                    if(location[0] == N) {
                        break;
                    } else {
                        location[0] = location[0] + 1;
                    }
                    break;
            }
        }

        return location;
    }

}
