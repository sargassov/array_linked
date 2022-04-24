package lists;

public class LinkedLizt<T> {

    private int size;
    private Node<T> first;
    private Node<T> last;

    static class Node<T>{
        private Node<T> prev;
        private T current;
        private Node<T> next;

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public void setCurrent(T current) {
            this.current = current;
        }

        public T getCurrent() {
            return current;
        }
    }

    public LinkedLizt(){
        first = new Node<>();
        last = first;
    }

    public LinkedLizt(T[] array){
        for(T t : array){
            addLast(t);
        }
    }

    public int size(){
        return size;
    }

    public T getFirst() {
        return first.getCurrent();
    }

    public T getLast() {
        return last.getCurrent();
    }

    public LinkedLizt(LinkedLizt<T> lizt){
        Node<T> node = lizt.first;
        for(int x = 0; x < lizt.size(); x++){
            addLast(node.getCurrent());
            if(node.getNext() != null)
                node = node.getNext();
        }
    }


    public void addFirst(T t){
        Node<T> node = new Node<>();
        node.current = t;
        if(size == 0){
            zeroSizeAdd(node);
            return;
        }
        first.setPrev(node);
        node.setNext(first);
        first = node;
        size += 1;
    }

    private void zeroSizeAdd(Node<T> node) {
        first = node;
        last = node;
        size += 1;
    }

    public void addLast(T t){
        Node<T> node = new Node<>();
        node.current = t;
        if(size == 0){
            zeroSizeAdd(node);
            return;
        }
        last.setNext(node);
        node.setPrev(last);
        last = node;
        size += 1;
    }


    public T removeFirst(){
        if(size == 0)
            throw new IndexOutOfBoundsException("Size of LinkedLizt is 0");

        T t = getFirst();
        if(size == 1){
            oneSizeRemove();
            return t;
        }
        first = first.getNext();
        first.setPrev(null);
        size -= 1;
        return t;
    }

    private void oneSizeRemove() {
        first = null;
        last = null;
        size -= 1;
    }

    public T removeLast(){
        if(size == 0)
            throw new IndexOutOfBoundsException("Size of LinkedLizt is 0");

        T t = getLast();
        if(size == 1){
            oneSizeRemove();
            return t;
        }
        last = last.getPrev();
        last.setNext(null);
        size -= 1;
        return t;
    }

    public T remove(int ind){
        if(ind < 1 || ind >= size - 1){
            throw new IndexOutOfBoundsException("Size of LinkedLizt is " + size + ". You can't remove element #" + ind + "!. Use removeFirst | removeLast");
        }
        Node<T> node = first;
        T t = null;
        for(int x = 0; x <= ind; x++){
            if(x == ind){
                t = node.getCurrent();
                Node<T> prevN = node.getPrev();
                Node<T> nextN = node.getNext();
                prevN.setNext(nextN);
                nextN.setPrev(prevN);
                size -= 1;
                break;
            }
            if(node.getNext() != null)
                node = node.getNext();
        }
        return t;
    }

    public void add(T t, int ind){
        if(ind < 0 || ind >= size)
            throw new IndexOutOfBoundsException("Size of LinkedLizt is " + size + ". You can't add element to positon #" + ind + "!");

        Node<T> node = first;
        for(int x = 0; x <= ind; x++){
            if(x == ind){
                Node<T> pastedNode = new Node<>();
                pastedNode.current = t;
                pastedNode.setNext(node);
                pastedNode.setPrev(node.getPrev());
                node.getPrev().setNext(pastedNode);
                node.setPrev(pastedNode);
                size += 1;
                break;
            }
            node = node.getNext();
        }
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LinkedLizt. size = " + size + ", [");
        if(size != 0){
            Node<T> node = first;
            for(int x = 0; x < size; x++){
                builder.append(node.current.toString()).append(", ");
                if(node.getNext() != null)
                    node = node.getNext();
            }
            builder = new StringBuilder(builder.substring(0, builder.length() - 2));
        }
        builder.append("]");
        return builder.toString();
    }

}
