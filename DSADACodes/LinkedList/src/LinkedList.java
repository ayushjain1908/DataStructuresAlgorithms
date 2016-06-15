public class LinkedList {
    private Node head;
    private int size;
    public int getSize(){
    return size;
    }
    public void setSize(int size){
        this.size = size;
    }
    public Node getHead(){
    return head;
    }
    public void setHead(Node head){
    this.head = head;
    }
    public void addNodeBegin(String info){
    if(head == null){
    head = new Node(info);
    }
    else{
    Node node = new Node(info);
    node.setNext(head);
    head = node;
    }
    size++;
    }
    public void addNodeEnd(String info){
    if(head == null){
    head = new Node(info);
    }
    else{
    Node node = new Node(info);
    Node curr = head;
    while(curr.getNext() != null){
    curr = curr.getNext();
    }
    curr.setNext(node);
    }
    size++;
    }
    public void addNodeNth(String info,int n){
    assert(n>=0);
    if(head == null){
    head = new Node(info);
    }
    else if(n==0){
    Node node = new Node(info);
    node.setNext(head);
    head = node;
    }
    else{
    Node curr = head;
    Node prev = null;
    int index = 0;
    while(curr != null && index < n){
    prev = curr;
    curr = curr.getNext();
    index++;
    }
    Node node = new Node(info);
    prev.setNext(node);
    node.setNext(curr);
    }
    size++;
    }
    public String deleteNodeBegin(){
    if(head == null){
    return null;
    }
    else{
    String info = head.getInfo();
    head = head.getNext();
    size--;
    return info;
    }
    }
    public String deleteNodeEnd(){
    if(head == null){
    return null;
    }
    else{
    Node curr =  head;
    Node prev = null;
    while(curr.getNext() != null){
    prev = curr;
    curr = curr.getNext();
    }
    String info = curr.getInfo();
    if(prev == null){
    head = null;
    }
    else{
    prev.setNext(null);
    }
    size--;
    return info;
    }
    }
    public void appendList(LinkedList m){
    assert(head != null && m.getHead()!=null);
    if(head == null){
    head = m.getHead();
    m.setHead(null);
    }
    else{
    Node curr = head;
    while(curr.getNext() != null){
    curr = curr.getNext();
    }
    curr.setNext(m.getHead());
    m.setHead(null);
    }
    size = size + m.getSize();
    }
    
    public static void frontBackSplit(Node head,LinkedList l,LinkedList m){
        int tcount = 0;
        int scount = 1;
        Node fastPtr = head;
        Node slowPtr = head;
        while(fastPtr != null){
            fastPtr = fastPtr.getNext();
            tcount++;
            if(fastPtr != null){
                fastPtr = fastPtr.getNext();
                tcount++;
                if(fastPtr != null){
                    slowPtr = slowPtr.getNext();
                    scount++;
                }
            }
        }
        m.setHead(slowPtr.getNext());
        m.setSize(tcount - scount);
        slowPtr.setNext(null);
        l.setHead(head);
        l.setSize(scount);
        
    }

    public void printList(){
    Node curr = head;
    while(curr != null){
    System.out.print(curr.getInfo() + "-->");
    curr = curr.getNext();
    }
    System.out.println();
    System.out.print("The size of linked list is " + getSize());
    }
    public static void main(String[] args) {
LinkedList l = new LinkedList();
LinkedList m = new LinkedList();
LinkedList p = new LinkedList();
LinkedList r = new LinkedList();
l.addNodeBegin("WED");
l.addNodeBegin("TUE");
l.addNodeBegin("MON");
l.addNodeBegin("SUN");
l.printList();
System.out.println();
String data = l.deleteNodeBegin();
if(data == null){
System.out.println("The linked list is empty");
}
else{
System.out.println("The deleted node from the beginning is " + data);
}
System.out.println("The linked list now is ");
l.printList();
l.addNodeEnd("FRI");
l.addNodeEnd("SAT");
System.out.println();
System.out.println("After adding FRI and SAT at the end,the list becomes");
   l.printList();
   data = l.deleteNodeEnd();
   System.out.println();
   if(data == null){
System.out.println("The linked list is empty");
}
else{
System.out.println("The deleted node from the end is " + data);
}
   System.out.println("The linked list now is ");
l.printList();
l.addNodeNth("THU",3);
System.out.println();
l.printList();
l.addNodeNth("SUN",0);
System.out.println();
l.printList();
l.addNodeNth("SAT",6);
System.out.println();
l.printList();
m.addNodeEnd("JAN");
m.addNodeEnd("APR");
m.addNodeEnd("JUN");
m.addNodeEnd("AUG");
System.out.println();
System.out.println("The second list is");
m.printList();
System.out.println();
System.out.println("Appending Days list with Months List");
l.appendList(m);
System.out.println("The list becomes");
l.printList();
System.out.println();
System.out.println("Front Back splitting the linked list l...");
frontBackSplit(l.getHead(), p, r);
System.out.println("After splitting the list becomes..");
p.printList();
System.out.println();
r.printList();
}
}