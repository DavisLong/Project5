public class BinaryTree<K extends Comparable<K>, V> {
    private Node<K, V> root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node<K, V> getRoot() {
        return this.root;
    }

    public void add(K key, V value) {

        Node<K,V> in = new Node<>(key,value);
        Node<K,V> cur = root;

        if(root == null){
            root = in;
        }
        Node<K,V> node = binarySearch(cur,key);
        if(node.getKey()==key){
            node.setValue(value);
        } else {
            if(node.getKey().compareTo(key)<0){
                node.setRight(in);
            } else {
                node.setLeft(in);
            }
        }


    }

    public V find(K key) {

        Node<K,V> cur = root;
        Node<K,V> search = binarySearch(cur,key);

        if(search.getKey()==key){
            return search.getValue();
        }else{
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public V[] flatten() {
        return (V[]) new Object[0];
    }

    public void remove(K key) {
        if(root.getKey().compareTo(key) == 0) {
            Node<K,V> temp = root.getLeft();
            root = root.getRight();
            addAll(temp);
        } else {

        }
    }
    private void addAll(Node<K,V> node){
        if(node ==null){
            return;
        } else {
            add(node.getKey(),node.getValue());
            addAll(node.getLeft());
            addAll(node.getRight());

        }
    }

    public boolean containsSubtree(BinaryTree<K, V> other) {
        return false;
    }

    private Node<K,V> binarySearch(Node<K,V> node,K key){
        if(node.getKey()==key){
            return node;
        } else if(node.getKey().compareTo(key)>0){
            if(node.getLeft()==null){
                return node;
            }else{
                binarySearch(node.getLeft(),key);
            }
        } else {
            if(node.getRight()==null){
                return node;
            }else{
                binarySearch(node.getRight(),key);
            }
        }
       return null;
    }
}
