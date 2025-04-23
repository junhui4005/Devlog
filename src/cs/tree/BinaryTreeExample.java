package src.cs.tree;

// 이진트리구조 예제
public class BinaryTreeExample{
    public static void main(String[] args) {
        Node root = new Node("a");
        root.left = new Node("b");
        root.right = new Node("c");

        preorder(root); // 전위 순회

        inorder(root); // 중위 순회

        postorder(root); // 후위 순회
    }


    public static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);

        }
    }
    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}