public class P_세그먼트트리 {
    static int[] arr = {1, 2, 3, 4}; // 원본 배열
    static int[] tree = new int[4 * arr.length]; // 세그먼트 트리 배열 (충분히 넉넉하게)
    static int n = arr.length;
    public static void main(String[] args) {
        // 세그먼트 트리 빌드
        build(1, 0, n - 1);
        // 트리 상태 확인 (디버깅용 출력)
        System.out.println("초기 세그먼트 트리:");
        for (int i = 1; i < 2 * n; i++) {
            System.out.printf("tree[%d] = %d\n", i, tree[i]);
        }
        // 쿼리 예시: [1, 3] 구간 합 = 2 + 3 + 4 = 9
        int result = query(1, 0, n - 1, 1, 3);
        System.out.println("쿼리 [1, 3] 결과: " + result); // 출력: 9
        // 업데이트 예시: arr[2] = 10으로 변경
        update(1, 0, n - 1, 2, 10);
        System.out.println("arr[2]를 10으로 변경 후 쿼리 [1, 3] 결과: " + query(1, 0, n - 1, 1, 3)); // 출력: 16
    }

    static void build(int node, int start, int end) {
        if (start == end) {
            // 리프 노드일 경우: 원본 배열 값을 저장
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            // 왼쪽 자식 트리 빌드
            build(2 * node, start, mid);
            // 오른쪽 자식 트리 빌드
            build(2 * node + 1, mid + 1, end);
            // 현재 노드는 자식 노드의 합
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    static int query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            // 범위 밖: 무시 (합이므로 0 리턴)
            return 0;
        }
        if (left <= start && end <= right) {
            // 현재 구간이 완전히 포함되면, 이 노드 값 사용
            return tree[node];
        }
        // 구간이 겹칠 경우 → 왼쪽, 오른쪽 자식에서 각각 구간합을 구해서 더함
        int mid = (start + end) / 2;
        int lSum = query(2 * node, start, mid, left, right);
        int rSum = query(2 * node + 1, mid + 1, end, left, right);
        return lSum + rSum;
    }

    static void update(int node, int start, int end, int index, int newValue) {
        if (start == end) {
            // 리프 노드까지 도달한 경우
            arr[index] = newValue;
            tree[node] = newValue;
        } else {
            int mid = (start + end) / 2;
            if (index <= mid) {
                // 왼쪽 자식으로 이동
                update(2 * node, start, mid, index, newValue);
            } else {
                // 오른쪽 자식으로 이동
                update(2 * node + 1, mid + 1, end, index, newValue);
            }
            // 리프에서 값이 바뀌었으니 부모도 다시 계산
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

}
