package org.example;

public class rbt < V extends Comparable < V >> {
    private Node root;

    public boolean contains(V value){
        Node node = root;
        while (node != null){
            if (node.value.equals(value)){
                return true;
            }
            if (node.value.compareTo(value) > 0){
                node = node.left;
            }else {
                node = node.right;
            }
        }
        return false;
    }

    private boolean addNode(Node node, V value){
        if (node.value == value){
            return false;
        }
        else {
            if (node.value.compareTo(value) > 0){
                if(node.left != null) {
                    boolean result = addNode(node.left, value);
                    node.left = rebalance(node.left);
                    return result;
                } else{
                    node.left = new Node();
                    node.left.color = true;
                    node.left.value = value;
                    return true;
                }
            } else {
                if(node.right != null) {
                    boolean result = addNode(node.right, value);
                    node.right = rebalance(node.right);
                    return result;
                } else{
                    node.right = new Node();
                    node.right.color = true;
                    node.right.value = value;
                    return true;
                }
            }
        }
    }
    public boolean add(V value){
        if (root != null){
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = false;
            return result;
        }
        else {
            root = new Node();
            root.color = false;
            root.value = value;
            return true;
        }
    }

    private Node rebalance(Node node){
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if(result.right != null && result.right.color == true &&
                    (result.left == null || result.left.color == false)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == true &&
                    result.left.left != null && result.left.left.color == true) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == true &&
                    result.right != null && result.right.color == true) {
                needRebalance = true;
                colorSwap(result);
            }
        }
        while (needRebalance);
        return result;
    }
    private Node rightSwap(Node node){
        Node rightCh = node.right;
        Node betweenCh = rightCh.left;
        rightCh.left = node;
        node.right = betweenCh;
        rightCh.color = node.color;
        node.color = true;
        return rightCh;
    }
    private Node leftSwap(Node node){
        Node leftCh = node.left;
        Node betweenCh = leftCh.right;
        leftCh.right = node;
        node.left = betweenCh;
        leftCh.color = node.color;
        node.color = true;
        return leftCh;
    }
    private void colorSwap(Node node){
        node.right.color = false;
        node.left.color = false;
        node.color = true;
    }

    private class Node{
        private V value;
        private Node left;
        private Node right;
        private boolean color;
    }

}
