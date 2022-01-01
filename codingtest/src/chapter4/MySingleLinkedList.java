package chapter4;

// My 붙이는 이유는 자바에서 제공하는 거와 겹치지 않게 해주기 위해서

public class MySingleLinkedList<T> {

    public Node<T> head; // 첫번째 노드
    public int size = 0; // 노드 개수

    public MySingleLinkedList(){
        head = null;
        size = 0;
    }

    public void addFirst(T item){
        Node<T> newNode = new Node<T>(item); // T : type parameter
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAfter(Node<T> before, T item){
        Node<T> temp = new Node<T>(item);
        temp.next = before.next;
        before.next = temp;
        size++;
    }

    public T removeFirst(){
        if(head == null)
            return null;
        T temp = head.data;
        head = head.next;
        size --;
        return temp;
    }

    public void add(int index, T item){

    }

    public T get(int index){
        return null;
    }

    public void remove(int index){

    }

    public int indexOf(T item){     //search
       return -1;
    }

    public static void main(String [] args){
        MySingleLinkedList<String> list = new MySingleLinkedList<String>();
        list.add(0, "Saturday");
        list.add(1, "Friday");
        list.add(0, "Monday"); // M -> S -> F
        list.add(2,"Tuesday"); // M-> S -> T -> F

        String str = list.get(2);
        list.remove(2);
    }
}
