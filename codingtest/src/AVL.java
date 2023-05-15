class Node1 {
    int key, height;
    Node1 left, right;

    Node1(int d) {
        key = d;
        height = 1;
    }
}

class AVLTree {
    Node1 root;

    int height(Node1 N) {
        if (N == null)
            return 0;

        return N.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node1 rightRotate(Node1 y) {
        Node1 x = y.left;
        Node1 T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node1 leftRotate(Node1 x) {
        Node1 y = x.right;
        Node1 T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalance(Node1 N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    Node1 insert(Node1 node1, int key) {
        if (node1 == null)
            return (new Node1(key));

        if (key < node1.key)
            node1.left = insert(node1.left, key);
        else if (key > node1.key)
            node1.right = insert(node1.right, key);
        else
            return node1;

        node1.height = 1 + max(height(node1.left),
                height(node1.right));

        int balance = getBalance(node1);

        if (balance > 1 && key < node1.left.key)
            return rightRotate(node1);

        if (balance < -1 && key > node1.right.key)
            return leftRotate(node1);

        if (balance > 1 && key > node1.left.key) {
            node1.left = leftRotate(node1.left);
            return rightRotate(node1);
        }

        if (balance < -1 && key < node1.right.key) {
            node1.right = rightRotate(node1.right);
            return leftRotate(node1);
        }

        return node1;
    }

    void preOrder(Node1 node1) {
        if (node1 != null) {
            System.out.print(node1.key + " ");
            preOrder(node1.left);
            preOrder(node1.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        tree.preOrder(tree.root);
    }
}