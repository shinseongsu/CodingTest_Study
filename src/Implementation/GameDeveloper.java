package Implementation;

/*
*
* 게임 개발
*
* 현민이는 게임 캐릭터가 맵 안에서 움직이는 시스템을 개발 중이다.
* 케릭터가 있는 장소는 1 x 1 크기의 정사각형으로 이뤄진 N X M 크기의 직사각형으로, 각각 칸은 육지 또는 바다이다.
* 캐릭터는 동서남북 중 한 곳을 바라본다.
*
* 맵의 각 칸은 (A, B)로 나타낼수 있고, A는 북쪽으로부터 떨어진 칸의 개수, B는 서쪽으로부터 떨어진 칸의 개수다.
* 캐릭터는 상하좌우로 움직일 수 있고, 바다로 되어 있는 공간에는 갈 수 없다.
*
* 1. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향 부터 차례대로 갈 곳을 정한다.
* 2. 캐릭터의 바로 왼쪽 방향에서 아직 가보지 않은 칸이 존재한다면, 왼쪽 방향으로 회전한 다음 왼쪽으로 한 칸을 전진한다.
*    왼쪽 방향에 가보지 않은 칸이 없다면, 왼쪽 방향으로 회전만 수행하고 1단계로 돌아간다.
* 3. 만약 네 방향 모두 이미 가본 칸이거나 바다로 되어 있는 칸인 경우에는, 바라보는 방향을 유지한 채로 한 칸 뒤로 가고
*    1단게로 돌아간다.
*    단, 뒤쪽 방향이 바다인 칸이라면 뒤로 갈수 없는 경우 움직임을 멈춘다.
*
* 현민이는 위 과정을 반복적으로 수행하면서 캐릭터의 움직임에 이상이 있는지 테스트하려고 한다.
* 메뉴얼에 따라 캐릭터를 이동시킨 뒤에, 캐릭터가 방문한 칸의 수를 출력하는 프로그램으로 만든다.
*
*
* 첫번째 입력값은 세로와 가로 크기를 입력한다.
*
* 두번째는 캐릭터가 있는 칸의 좌표 (A, B)와 바라보는 방향 d 가 각각 서로 공백으로 구분하여 주어진다.
* - 0 : 북쪽
* - 1 : 동쪽
* - 2 : 남쪽
* - 3 : 서쪽
*
* 세번째는 육지인지 바다인지 맵을 그려준다.
* 맵의 외각은 항상 바다로 되어 있다.
*
* - 0 : 육지
* - 1 : 바다
*
*
*
 */
public class GameDeveloper {

    public static void main(String[] args) {

        int width = 4;          // 가로
        int height = 4;         // 세로

        int[] location = { 1, 1, 0};    // (1,1) 의 북쪽을 보고 있다.

        int[][] board = {
                { 1, 1, 1, 1},
                { 1, 0, 0, 1},
                { 1, 1, 0, 1},
                { 1, 1, 1, 1}
        };

        int result = solution(width, height, location, board);

        System.out.println(result);
    }
                            // 위쪽, 왼쪽, 아래, 오른쪽
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    private static int solution(int width, int height, int[] location, int[][] board) {

        int time = 1;
        int turn_time = 0;  // 4번 왼쪽 돌아 돌아오면 뒤로가기( 뒤로 돌때 바다면 게임 끝

        int nx = location[0];   // 위치 가로
        int ny = location[1];   // 위치 세로
        int direction = location[2];    // 보고있는 방향

        int[][] no_board = new int[width][height];

        no_board[nx][ny] = 1;   // 갔던곳 표시

        // 시뮬레이션
        while(true) {
            System.out.println( "x 좌표 : " + nx + ", y 좌표 :" + ny);
//            System.out.println(NoBoardWalk(no_board, nx, ny, direction));
//            System.out.println(board[nx + dx[direction]][ny + dy[direction]] == 0 );
            // 전방에 안간 곳이 있고,  바다가 바로 앞에 아닐때
            if( NoBoardWalk(no_board, nx, ny, direction) && board[nx + dx[direction]][ny + dy[direction]] == 0 ) {
                nx += dx[direction];
                ny += dy[direction];
                no_board[nx][ny] = 1;
                time++;
            // 전방에 모두 갔고 앞에 바다가 있을때 회전
            } else if ( !NoBoardWalk(no_board, nx, ny, direction) || board[nx + dx[direction]][ny + dy[direction]] == 1) {
                if(turn_time != 4) {    // 제자리에서 4번 돌지 않았을 때,
                    direction = TurnLeft(direction);
                    turn_time += 1;
                } else {                // 제자리에서 4번 돌았을 때,
                    if(board[nx - dx[direction]][ny - dy[direction]] == 1 ) {
                        break;
                    }
                }
            }
        }

        return time;

    }

    // 보고 있는 곳에 안간곳이 있는지 확인
    private static boolean NoBoardWalk(int[][] board, int width, int height, int direction) {

        switch(direction) {
            case 0: // 북쪽
                for(int i = height ; i > 0 ; --i) {
                    System.out.println(board[i]);
                    if(board[width][i] == 0)
                        return true;
                }
                break;
            case 1: // 왼쪽
                for(int i = width ; i > 0 ; --i) {
                    if(board[i][height] == 0)
                        return true;
                }
                break;
            case 2: // 남쪽
                for(int i = height ; i < board.length ; ++i) {
                    if(board[width][i] == 0)
                        return true;
                }
                break;
            case 3: // 오른쪽(동쪽)
                for(int i = width ; i < board[0].length ; ++i) {
                    if(board[i][height] == 0)
                        return true;
                }
                break;
        }
        return false;
    }

    private static int TurnLeft(int direction) {
        if(direction == 3) {
            direction = 0;
        } else {
            direction++;
        }

        return direction;
    }

}
