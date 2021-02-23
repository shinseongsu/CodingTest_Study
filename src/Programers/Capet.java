package Programers;

/**
 *
 *  Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고
 *  테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
 *
 *  Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
 *
 * Leo가 본 카펫에서 갈색 격자의 수 brown,
 * 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의
 * 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * brown 50, yellow 22 로 테스트해보시기 바랍니다.
 * 기댓값은 [24,3] 입니다.
 *
 *
 * 입출력 예
 * brown	yellow	return
 * 10	    2	    [4, 3]
 *
 * ####
 * #oo#
 * ####
 *
 * 8	    1	    [3, 3]
 *
 * ###
 * #o#
 * ###
 *
 * 24	    24	    [8, 6]
 *
 * ########
 * ##oooo##
 * #ooooo##
 * ##oooop#
 * ##oooo##
 * ########
 *
 */
public class Capet {
    public static void main(String[] args) {
        int brown = 50;
        int yellow = 22;

        int[] result = solution(brown, yellow);

        for(int i : result ) {
            System.out.println(i);
        }
    }

    public static int[] solution(int brown, int yellow) {

        int height = 0;
        int width = 0;
        for (height = 3; height <= (int) (brown + 4) / 2; height++) {

            width = ((brown + 4) / 2) - height;
            if (width < height) {
                break;
            }

            int redCount = (width - 2) * (height - 2);
            if (yellow == redCount) {
                break;
            }
        }

        int[] answer = new int[] { width, height };
        return answer;
    }
}
