package BackJoon.Level1;

/**
 * 고양이
 *
 * 문제
 * 아래 예제와 같이 고양이를 출력하시오.
 *
 * 출력
 * 고양이를 출력한다.
 *
 * \    /\
 *  )  ( ')
 * (  /  )
 *  \(__)|
 *
 */
public class Cat {
    public static void main(String[] args) {
        char[][] cat = {
                { '\\', ' ' ,' ',' ', ' ', '/', '\\', ' '},
                { ' ' , ')' ,' ',' ', '(', ' ', '\'', ')'},
                { '(' , ' ' ,' ','/', ' ', ' ', ')' , ' '},
                { ' ' , '\\','(','_', '_', ')', '|' , ' '}
        };

        for(int i = 0 ; i < cat.length ; i++) {
            for (int j = 0 ; j < cat[i].length ; j++) {
                System.out.print(cat[i][j]);
            }
            System.out.println();
        }
    }
}
