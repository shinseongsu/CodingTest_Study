package Search;

public class BinarySearch1 {

    // 이진 탐색 반복문으로 실행
    public static void main(String[] args) {
        int[] arr = {0, 2, 4, 6, 8, 10, 12, 14 ,16, 18};

        int result = binarySearch(arr, 8, 0, arr.length - 1);
        if (result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        } else {
            System.out.println(result + 1);
        }
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
}
