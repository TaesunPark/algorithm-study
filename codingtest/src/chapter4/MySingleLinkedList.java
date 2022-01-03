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

    public void add(int index, T item){
        if(index < 0 || index > size)
            return;

        if(index == 0)
            addFirst(item);
        else{
            addAfter(getNode(index-1), item);
        }
    }

    public T removeFirst(){
        if(head == null)
            return null;
        T temp = head.data;
        head = head.next;
        size --;
        return temp;
    }

    public T removeAfter(Node<T> before){
        if(before.next == null)
            return null;
        T temp = before.next.data;
        before.next = before.next.next;
        size --;
        return temp;
    }

    public T remove(int index){
        if(index >= size || index <0){
            return null;
        }

        if(index == 0){
            return removeFirst();
        } else{
            return removeAfter(getNode(index-1));
        }
    }

    public T remove(T item){
        Node<T> p = head;
        Node<T> q = null;

        while(p!=null || p.data.equals(item)){
            q = p;
            p = p.next;
        }

        if(p == null)
            return null;
        if(q == null)
            return removeFirst();
        else{
            return removeAfter(q);
        }
    }

    public Node<T> getNode(int index){

        if(index ==0 || index>=size){
            return null;
        }

        Node<T> p = head;
        for(int i=0; i<index; i++){
                p = p.next;
        }
        return p;
    }

    public T get(int index){
        if(index >= size || index == 0){
            return null;
        }
        Node <T> p = head;
        for(int i=0; i<index; i++){
            p = p.next;
        }
        return p.data;
    }

    public int indexOf(T item){     //search
       Node <T> p = head;
       int index = 0;
       while(p!=null){
           if(p.data.equals(item)) // 비교 연산자 "==" 이건 오로지 프리미티브 타입의 연산자에서만 사용 가능함.
               return index;
           p = p.next;
           index++;
       }
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
