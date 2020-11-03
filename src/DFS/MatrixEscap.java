package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 미로 탈출
 *
 * 동빈이는 N * M 크기의 직사각형 형태의 미로에 갇혀 있다.
 * 미로에는 여러마리의 괴물이 있어 이를 피해 탈출해야한다.
 * 동빈이의 위치는 (1,1)이고 미로의 출구는 (N, M)의 위치에 존재하며 한번에 한칸씩 이동할 수 있다.
 * 이때 괴물이 있는 부분은 0으로, 괴물이 없는 부분은 1로 표시되어 있다.
 * 미로는 반드시 탈출할 수 있는 형태로 제시된다.
 * 이때, 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 개수를 구하시오.
 *
 */
public class MatrixEscap {
    private static int[][] arr;

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[N][M];

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.getIndex();
            y = node.getDistance();

            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length) continue;
                // 벽인 경우 무시
                if (arr[nx][ny] == 0) continue;
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = arr[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        return arr[arr.length - 1][arr[0].length - 1];
    }


}

class Node {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }
}