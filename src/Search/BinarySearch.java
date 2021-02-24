package Search;

/**
 * 이진 탐색
 *
 * 배열 내부의 데이터가 정렬되어 있어야만 사용할 수 있는 알고리즘이다.
 * 데이터가 무작위일떄 사용할 수 없지만, 이미 정렬되어 있다면 빠르게 데이터를 찾을 수 있다는 특징이 있다.
 * 이진 탐색은 탐색 범위를 절반씩 좁혀가며 데이터를 탐색하는 특징이 있다.
 *
 * 이진 탐색은 위치를 나타내는 변수 3개를 사용하여, 탐색하고자 하는 범위의 시작점, 끝점, 그리고 중간점이다.
 * 찾으려는 데이터와 중간점 위치에 있는 데이터를 반복적으로 비교해서 원하는 데이터를 찾는게 이진 탐색과정이다.
 *
 *
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {0, 2, 4, 6, 8, 10, 12, 14 ,16, 18};

        int result = binarySearch(arr, 8, 0, arr.length-1);
        if(result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        } else {
            System.out.println(result + 1);
        }
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        if(start > end) return -1;
        int mid = (start + end) / 2;

        if(arr[mid] == target) return mid;
        else if(arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
        else return binarySearch(arr, target, mid + 1, end);
    }

}
