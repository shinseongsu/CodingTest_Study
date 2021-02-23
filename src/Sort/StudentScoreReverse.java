package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * N명의 학생 정보가 있다.
 * 학생 정보는 학생의 이름과 학생의 성적으로 구분된다.
 *
 * 각 학생의 이름과 성적 정보가 주어졌을때, 성적이 낮은 순서대로 학생의 이름을 출력하는 프록그램을 작성하시오.
 *
 */
public class StudentScoreReverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            students.add(new Student(name, score));
        }

        Collections.sort(students);

        students.stream().map(o -> o.getName() + " ").forEach(System.out::print);
    }

}

class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    // 정렬 기준은 '점수가 낮은 순서'
    @Override
    public int compareTo(Student other) {
        if (this.score < other.score) {
            return -1;
        }
        return 1;
    }
}
