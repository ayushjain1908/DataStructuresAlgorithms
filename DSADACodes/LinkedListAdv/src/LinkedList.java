
public class LinkedList {

	private Node head;
	public Node getHead(){
		return head;
	}
	public void setHead(Node head){
		this.head = head;
	}
	public void addNodeBegin(int info){
	    if(head == null){
	    head = new Node(info);
	    }
	    else{
	    Node node = new Node(info);
	    node.setNext(head);
	    head = node;
	    }
   }
	public void printList(){
	    Node curr = head;
	    if(head == null){
	    	System.out.println("The linked list is empty");
	    	return;
	    }
	    while(curr != null){
	    System.out.print(curr.getInfo() + "-->");
	    curr = curr.getNext();
	    }
	    System.out.println();
	}
	public static void removeDupSorted(LinkedList l){
		Node head = l.getHead();
		if(head == null){
			return;
		}
		Node curr = head.getNext();
		Node prev = head;
		while(curr != null){
			if(curr.getInfo() == prev.getInfo()){
				prev.setNext(curr.getNext());
				curr.setNext(null);
				curr = prev.getNext();
			}
			else{
				prev = curr;
				curr = curr.getNext();
			}
		}
	}
	public static LinkedList mergeSortedLists(LinkedList l,LinkedList m){
		Node lcurr= l.getHead();
		Node mcurr = m.getHead();
		if(lcurr == null){
			return m;
		}
		else if(mcurr == null){
			return l;
		}
		LinkedList result = new LinkedList();
		if(lcurr.getInfo() < mcurr.getInfo()){
			result.setHead(lcurr);
			lcurr = lcurr.getNext();
		}
		else{
			result.setHead(mcurr);
			mcurr = mcurr.getNext();
		}
		result.getHead().setNext(null);
		Node rcurr = result.getHead();
		while(lcurr != null && mcurr != null ){
			if(lcurr.getInfo() < mcurr.getInfo()){
				rcurr.setNext(lcurr);
				lcurr = lcurr.getNext();
			}
			else{
				rcurr.setNext(mcurr);
				mcurr = mcurr.getNext();
			}
			rcurr = rcurr.getNext();
		}
		if(lcurr != null){
			rcurr.setNext(lcurr);
		}
		else{
			rcurr.setNext(mcurr);
		}
		l.setHead(null);
		m.setHead(null);
		return result;
	}
	public static Node reverseListIterative(LinkedList l){
		Node head = l.getHead();
		if(head == null || head.getNext() == null){
			return head;
		}
		Node curr = head.getNext();
		Node prev = head;
		prev.setNext(null);
        while(curr != null){
        	Node next = curr.getNext();
        	curr.setNext(prev);
        	prev = curr;
        	curr = next;
        }				
        return prev;
	}
	
	public static void main(String[] args) {
		LinkedList l =  new LinkedList();
		l.addNodeBegin(71);
		l.addNodeBegin(52);
		l.addNodeBegin(49);
		l.addNodeBegin(49);
		l.addNodeBegin(49);
		l.addNodeBegin(31);
		l.addNodeBegin(22);
		l.addNodeBegin(22);
		l.addNodeBegin(13);
		l.printList();
		LinkedList m = new LinkedList();
		m.addNodeBegin(69);
		m.addNodeBegin(57);
		m.addNodeBegin(47);
		m.addNodeBegin(33);
		m.addNodeBegin(20);
		m.addNodeBegin(6);
		System.out.println();
		m.printList();
		System.out.println("Removing the duplicates from the first list.....");
		removeDupSorted(l);
		System.out.println("The first linked list becomes");
		l.printList();
		System.out.println();
		System.out.println("Merging these two sorted lists ...");
		LinkedList n = mergeSortedLists(l, m);
		System.out.println("The linked list becomes :");
		n.printList();
		System.out.println();
		System.out.println("Reversing the merged list....");
		Node newHead = reverseListIterative(n);
		n.setHead(newHead);
		System.out.println("The linked list becomes:");
		n.printList();
	}
}
