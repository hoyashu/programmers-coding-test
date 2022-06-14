package study.tree;

class TreeGo {

    NodeGo root;

    //초기 제귀함수 셋팅
    public void makeTreeGo(int[] a) {
        //최초 실행시 처음부터 끝 index까지 실행
        //⛔질문 : root에 정확히 어떤게 담기길래 main에서 root를 사용하는건지 모르겠음
        this.root = makeTreeRGo(a, 0, a.length - 1);
    }

    //제귀함수 (중간 찾아서 반쪼개서 트리만들어서 최종값node돌려주기)
    public NodeGo makeTreeRGo(int[] a, int start, int last) {
        //제귀함수 중단
        if (start > last) return null;

        //중간 찾기
        //형변환으로 소수점부분은 제외하고 자동으로 정수부분만 들어감 - https://jhnyang.tistory.com/207
        //int mid = (int) Math.floor((start + last) / 2);
        int mid = (start + last) / 2;

        NodeGo node = new NodeGo(a[mid]);
        node.left = makeTreeRGo(a, start, mid - 1);
        node.right = makeTreeRGo(a, mid + 1, last);

        return node;
    }

    public void searchTreeGo(NodeGo node, int find) {
        if (find < node.data) {
            System.out.println("small " + node.data);
            searchTreeGo(node.left, find);
        } else if (find > node.data) {
            System.out.println("big " + node.data);
            searchTreeGo(node.right, find);
        } else {
            System.out.println("same " + node.data);
        }
    }

    class NodeGo {
        int data;
        NodeGo left;
        NodeGo right;

        NodeGo(int data) {
            this.data = data;
        }
    }

}

//실행
public class TreeTestGO {
    public static void main(String[] args) {
        int[] a = new int[6];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        TreeGo treeGo = new TreeGo();
        treeGo.makeTreeGo(a);
        treeGo.searchTreeGo(treeGo.root, 1);

    }
}
