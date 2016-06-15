import java.util.HashSet;
import java.util.Stack;


public class MyLinkedList {

	private ListNode head;
	private ListNode tail;
	public ListNode getHead(){
		return head;
	}
	public void setHead(ListNode head){
		this.head = head;
	}
	//-----------------------------------------Add a node at last ---------------------------------------------
	public void addLast(int data){
		ListNode node = new ListNode(data);
		if(head == null){
			head = node;
			tail = node;
		}
		else{
			tail.next = node;
			tail = node;
		}
	}
	
	//---------------------------------------Reverse the list recursively ---------------------------------------
	public void reverseListRecursive(){
		reverseListRecursive(head);
	}
	
	public void reverseListRecursive(ListNode curr){
		if(curr == null){
			return;
		}
		if(curr.next == null){
			tail =  head;
			head = curr;
			return;			
		}
		reverseListRecursive(curr.next);
		curr.next.next = curr;
		curr.next = null;
	}
	
	//---------------------------------------- Reverse the list iteratively ------------------------------------
	public void reverseListIterative(){
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		tail = head;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	
	// ---------------------------------------- Print the list --------------------------------------------------
	public void printList(){
		ListNode t = head;
		while(t != null){
			System.out.print(t.data + "-->");
			t=t.next;
		}
	}
	
	// -------------------------------------- Getting the list size ----------------------------------------
	public int getSize(){
		int count = 0;
		ListNode p = head;
		while(p != null){
			count++;
			p = p.next;
		}
		return count;
	}
	
	// ---------------------------------------Nth Node from end Iterative-----------------------------------------
	public ListNode nthFromEnd(int n){
		ListNode fast = head;
		ListNode slow = head;
		int count = 1;
		while(fast != null && count != n + 1){
			fast = fast.next;
			count++;
		}
		if(count != n + 1){
			System.out.println("Invalid Input");
			return null;
		}
		else{
			while(fast != null){
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
	}
	
	// ------------------------------------------ Nth node from end Recursive --------------------------------
	public ListNode nthFromEndRecursive(int n){
		IntWrapper i = new IntWrapper();
		return nthFromEndRecursive(head,n,i);
	}
	
	public ListNode nthFromEndRecursive(ListNode curr,int n, IntWrapper i){
		if(curr == null){
			return null;
		}
		ListNode node = nthFromEndRecursive(curr.next, n, i);
		i.value = i.value + 1;
		if(i.value == n){
			return curr;
		}
		return node;
	}
	
	// ---------------------------------------- Removing Duplicates from Linked List -------------------------
	public void removeDuplicates(){
		HashSet<Integer> set = new HashSet<Integer>();
		ListNode curr = head;
		ListNode prev = null;
		while(curr != null){
			if(set.contains(curr.data)){
				prev.next = curr.next;
			}
			else{
				set.add(curr.data);
				prev = curr;
			}
			curr = curr.next;
		}
	}
	
	//---------------------------------- Partition list around a value (Stable)  ------------------------------------
	public void partitionListStable(int x){
		ListNode beforeHead = null;
		ListNode beforeTail = null;
		ListNode afterHead = null;
		ListNode afterTail = null;
		ListNode node = head;
		ListNode next;
		while(node  != null){
			next = node.next;
			node.next = null;
			if(node.data <= x){
				if(beforeHead == null){
					beforeHead = node;
					beforeTail = node;
				}
				else{
					beforeTail.next = node;
					beforeTail =  node;
				}
				
			}
			else{
				if(afterHead == null){
					afterHead = node;
					afterTail = node;
				}
				else{
					afterTail.next= node;
					afterTail = node;
				}
			}
			node = next;
		}
		if(beforeHead == null){
			head = afterHead;
			tail = afterTail;
		}
		else{
		   head = beforeHead;
		   beforeTail.next = afterHead;
		   if(afterTail == null){
			   tail = beforeTail;
		   }
		   else{
			   tail = afterTail;
		   }
		}
	}
	
	// ------------------------ Create a loop in a list of specified length ---------------------------------
	public void createLoop(int n){
		ListNode x = nthFromEnd(n);
		tail.next = x;
		tail = null;
	}
	
	//------------------------ Detect a loop in the linked list (Floyyd's Algorithm)--------------------------
	public boolean detectLoop(){
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		while(fastPtr != null && fastPtr.next!=null){
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(slowPtr == fastPtr){
				return true;
			}
		}
		return false;
	}
	public static ListNode findLoopBeginning(MyLinkedList list){
		ListNode fastPtr = list.getHead();
		ListNode slowPtr = list.getHead();
		while(fastPtr != null && fastPtr.next != null){
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(fastPtr == slowPtr){
				break;
			}		
		}
		if(fastPtr == null || fastPtr.next == null){
			return null;
		}
		slowPtr = list.getHead();
		while(slowPtr != fastPtr){
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}
		return slowPtr;
	}
	
	// ---------------------------Partition list around value,space optimized,Non Stable ---------------------
	public void partitionListSpaceEff(int x){
		ListNode lHead = head;
		ListNode lTail = head;
		ListNode node = head;
		ListNode next;
		while(node != null ){
			next = node.next;
			if(node.data <= x){
				node.next = lHead;
				lHead = node;
			}
			else{
				lTail.next = node;
				lTail = node;
			}
			node = next;
		}
		lTail.next = null;
		head = lHead;
		tail = lTail;
	}
	
	// -------------------------------------  Reverse every K nodes -------------------------------------------
	public static ListNode reverseEveryKnodes(ListNode head,int k){
		int count = 0;
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		while(curr != null && count < k){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if(curr != null){
			head.next = reverseEveryKnodes(curr, k);
		}
		return prev;
	}
	
	//------------------------------------Reverse alternate K nodes--------------------------------------------
	public static ListNode reverseAlternateKnodes(ListNode head,int k){
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		int count = 0;
		while(curr != null && count < k){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		head.next = curr;
		count = 0;
		// skip k nodes
		while(curr != null && count < k - 1){
			curr = curr.next;
			count++;
		}
		if(curr != null && curr.next != null){
			curr.next = reverseAlternateKnodes(curr.next, k);
		}
		return prev;
	}
	
	//----------------------------------------- Merge Sorted Lists --------------------------------------------
	public static ListNode mergeSortedLists(MyLinkedList l1,MyLinkedList l2){
		ListNode l1ptr = l1.getHead();
		ListNode l2ptr = l2.head;
		ListNode newHead = null;
		ListNode ptr = null;
		if(l1ptr == null){
			return l2ptr;
		}
		if(l2ptr == null){
			return l1ptr;
		}
		if(l1ptr.data <= l2ptr.data){
			newHead = l1ptr;
			l1ptr = l1ptr.next;
		}
		else{
			newHead = l2ptr;
			l2ptr = l2ptr.next;
		}
		ptr = newHead;
		while(l1ptr != null && l2ptr != null){
			if(l1ptr.data <= l2ptr.data){
				ptr.next = l1ptr;
				l1ptr = l1ptr.next;
			}
			else{
				ptr.next = l2ptr;
				l2ptr = l2ptr.next;
			}
			ptr = ptr.next;
		}
		if(l1ptr == null){
			ptr.next = l2ptr;	
		}
		else{
			ptr.next = l1ptr;
		}
		return newHead;	
	}
	
	// -------------------------------------- Find lists intersection Point using Aux Space--------------------
	public static ListNode findIntersectionNode(MyLinkedList l1,MyLinkedList l2){
		if(l1.head == null || l2.head == null){
			return null;
		}
		ListNode l1p = l1.head;
		ListNode l2p = l2.head;
		HashSet<ListNode> set = new HashSet<ListNode>();
		while(l1p != null){
			set.add(l1p);
			l1p = l1p.next;
		}
		while(l2p != null){
			if(set.contains(l2p)){
				return l2p;
			}
			l2p = l2p.next;
		}
		return null;
	}
	
	// ---------------------------------- Find intersection point using length difference ----------------------
	public static ListNode findIntersectionPointUsingLenDiff(MyLinkedList l1, MyLinkedList l2){
		ListNode lp1 = l1.head;
		ListNode lp2 = l2.head;
		int len1 = 0;
		int len2 = 0;
		int diff = 0;
		if(lp1 == null || lp2 == null){
			return null;
		}
		while(lp1.next != null){
			len1++;                                             //not exactly the len,but len - 1
			lp1 = lp1.next;			
		}
		while(lp2.next !=  null){
			len2++;
			lp2 = lp2.next;
		}
		if(lp1 != lp2){
			return null;
		}
		if(len1 >= len2){
			diff = len1 - len2;
			lp1 = l1.getHead();
			lp2 = l2.getHead();
		}
		else{
			diff = len2 - len1;
			lp1 = l2.head;
	        lp2 = l1.head;
		}
		while(diff > 0){
			lp1 = lp1.next;
			diff--;
		}
		while(lp1 != lp2){
			lp1 = lp1.next;
			lp2 = lp2.next;
		}
		return lp1;
	}
	
	// --------------------- Add LinkedList Numbers represented in natural order using Stacks ------------------
	public ListNode addTwoLinkedListNumbersInNaturalOrderUsingStacks(ListNode lp1,ListNode lp2){
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		ListNode result = null;
		int carry = 0;
		while(lp1 != null){
			stack1.push(lp1.data);
			lp1 = lp1.next;
		}
		while(lp2 != null){
			stack2.push(lp2.data);
			lp2 = lp2.next;
		}
		while(!stack1.empty() && !stack2.empty()){
			int val1 = stack1.pop();
			int val2 = stack2.pop();
			int sum = val1 + val2 + carry;
			int digit = sum % 10;
			carry = sum / 10;
			ListNode node = new ListNode(digit);
			if(result == null){
				result = node;
			}
			else{
				node.next = result;
				result = node;
			}
		}
		while(!stack1.empty()){
			int sum = stack1.pop() + carry;
			int digit = sum % 10;
			carry = sum / 10;
			ListNode node = new ListNode(digit);
			if(result == null){
				result = node;
			}
			else{
				node.next = result;
				result =  node;
			}
		}
		while(!stack2.empty()){
			int sum = stack2.pop() + carry;
			int digit = sum % 10;
			carry = sum / 10;
			ListNode node = new ListNode(digit);
			if(result == null){
				result = node;
			}
			else{
				node.next = result;
				result =  node;
			}
		}
		if(carry > 0){
			ListNode node = new ListNode(carry);
			node.next = result;
			result = node;
		}
//	    ListNode i = result;
//	    while(i != null){
//	    	System.out.print(i.data + "-->");
//	    	i = i.next;
//	    }
//	    System.out.println();
    	return result;
	}
	
	// ------------------------------Add Linked List Numbers represented in reverse order ---------------------
	public void  addTwoLinkedListNumbersInReverseOrder(ListNode lp1,ListNode lp2){
		int carry = 0;
		while(lp1 != null && lp2 != null){
			int sum = lp1.data + lp2.data + carry;
			int digit = sum % 10;
			carry = sum / 10;
			addLast(digit);
			lp1 = lp1.next;
			lp2 = lp2.next;
		}
		while(lp1 != null){
			int sum = carry + lp1.data;
			int digit = sum % 10;
			carry = sum / 10;
			addLast(digit);
			lp1 = lp1.next;
		}
		while(lp2 != null){
			int sum = carry + lp2.data;
			int digit = sum % 10;
			carry = sum / 10;
			addLast(digit);
			lp2 = lp2.next;
		}
		if(carry > 0){
			addLast(carry);
		}
	}
	
	//-------------------------Add linked list numbers represented in Natural Order Recursive ----------------
	public void addTwoLinkedListNumbersInNaturalOrderRecursive(ListNode l1Head,ListNode l2Head){
		ListNode lp1 = l1Head;
		ListNode lp2 = l2Head;
		ListNode longList;
		int len1 = 0 ; 
		int len2 = 0 ;
		int diff = 0;
		int[] carry = new int[1];
		carry[0] = 0;
		while(lp1 != null){
			len1++;
			lp1 = lp1.next;
		}
		while(lp2 != null){
			len2++;
			lp2 = lp2.next;
		}
		if(len1 == len2){
			head = addTwoLinkedListsSameSize(l1Head,l2Head,carry);
		}
		else{
			if(len1 > len2){
				diff = len1 - len2;
				lp1 = l1Head;
				lp2 = l2Head;
				longList = l1Head;
			}
			else{
				diff = len2 - len1;
				lp1 = l2Head;
				lp2 = l1Head;
				longList = l2Head;
			}
			int dist = diff;
			while(diff > 0){
				lp1 = lp1.next;
				diff--;
			}
			head = addTwoLinkedListsSameSize(lp1, lp2, carry);
			head = addCarryToRemaining(longList, head, dist, carry);
		}
		if(carry[0] > 0){
			ListNode carryNode = new ListNode(carry[0]);
			carryNode.next = head;
			head = carryNode;
		}
	}
	
	public ListNode addTwoLinkedListsSameSize(ListNode l1Head,ListNode l2Head,int[] carry){
		if(l1Head == null){
			return null;
		}
		ListNode resultNode = new ListNode();
		resultNode.next = addTwoLinkedListsSameSize(l1Head.next,l2Head.next, carry);
		int sum = l1Head.data + l2Head.data + carry[0];
		int digit = sum % 10;
		carry[0] = sum / 10;
		resultNode.data = digit;
		return resultNode;
	}
	
	public ListNode addCarryToRemaining(ListNode lp ,ListNode head,int dist,int[] carry){
		if(dist == 0){
			return head;
		}
		ListNode resultNode = new ListNode();
		dist--;
		resultNode.next = addCarryToRemaining(lp.next,head,dist,carry);
		int sum = lp.data + carry[0];
		int digit = sum % 10;
		carry[0] = sum / 10;
		resultNode.data = digit;
		return resultNode;
	}
	
	// ------------- Checking is the list is a Palindrome using Stacks ------------------------------------
	public boolean isPalindromeUsingStack(){
		ListNode fast = head;
		ListNode slow = head;
		Stack<Integer> stack = new Stack<Integer>();
		while(fast != null && fast.next != null){
			stack.push(slow.data);
			fast = fast.next.next;
			slow = slow.next;
		}
		// if odd then skip current slow node
		if(fast != null){
			slow = slow.next;
		}
		while(slow != null){
			if(slow.data != stack.pop()){
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	
	// --------------------- Palindrome Check Recursive -----------------------------------------------------
	public boolean isPalindromeRecursive(){
		Result res = isPalindromeRecursive(head,getSize());
		return res.match;
	}
	
	private Result isPalindromeRecursive(ListNode head, int length){
		if(head == null || length == 0){
			return new Result(null,true);
		}
		else if(length == 1){
			return new Result(head.next,true);
		}
		else if(length == 2){
			boolean val = head.data == head.next.data;
			return new Result(head.next.next,val);
		}
		Result res = isPalindromeRecursive(head.next, length - 2);
		if(res.match == false){
			return res;
		}
		else{
			boolean val = head.data ==  res.node.data;
			ListNode next = res.node.next;
			res.match = val;
			res.node = next;
			return res;
		}
	}
	
	// ------------------------------------------ List node class definition -----------------------------------
	private class ListNode{
	    private int data;
		private ListNode next;
	    ListNode(int data){
			this.data = data;
		}
		public ListNode() {
			
		}
	}
	
	// ------------------------------------------- Int Wrapper Class definition -------------------------------
	private class IntWrapper{
		int value = 0;
	}
	
	//---------------------------------- Wrapper class for Palindrome Recursive -------------------------------
	public class Result{
		public ListNode node;
		public boolean match;
		public Result(ListNode node,boolean match){
			this.match = match;
			this.node = node;
		}
	}
	
	
	//---------------------------------------- Driver method AKA Main Method -------------------------------------
	public static void main(String[] args) {
//		MyLinkedList list = new MyLinkedList();
//		int i = 1;
//		while(i <= 8){
//			list.addLast(i);
//			i++;
//		}
//		list.printList();
//		//list.reverseListIterative();
//		System.out.println();
////		System.out.println("Reversing every 3 nodes in the list");
////		ListNode newHead = reverseEveryKnodes(list.getHead(),3);
//		System.out.println("Reversing alternate 3 nodes");
//		ListNode newHead = reverseAlternateKnodes(list.getHead(), 3);
//		list.setHead(newHead);
//		list.printList();
		//ListNode m = list.nthFromEndRecursive(3);
	    //System.out.println( (m != null ) ? m.data : "Invalid");
//		MyLinkedList dupList = new MyLinkedList();
//		dupList.addLast(1);
//		dupList.addLast(1);
//		dupList.addLast(2);
//		dupList.addLast(3);
//		dupList.addLast(2);
//		dupList.addLast(2);
//		dupList.addLast(4);
//		dupList.addLast(5);
//		dupList.addLast(4);
//		dupList.printList();
//		dupList.removeDuplicates();
//		System.out.println();
//		dupList.printList();
//		MyLinkedList l = new MyLinkedList();
//		l.addLast(2);
//		l.addLast(9);
//		l.addLast(3);
//		l.addLast(4);
//		l.addLast(6);
//		l.addLast(1);
//		l.addLast(12);
//		l.addLast(15);
//		l.addLast(5);
//		l.addLast(7);
//		l.addLast(19);
//		l.printList();
//		System.out.println();
//		System.out.println("Partitioning the list around value  8............. ");
//		l.partitionListSpaceEff(8);
//		l.printList();
//		System.out.println("Introducing loop of length 6 at end");
//		l.createLoop(6);
//		System.out.println("Is there a loop ? " + l.detectLoop());
//		ListNode loopNode = findLoopBeginning(l);
//		System.out.println("The loop begins at " + ((loopNode != null) ? loopNode.data : loopNode));
//		MyLinkedList l1 = new MyLinkedList();
//		MyLinkedList l2 = new MyLinkedList();
//		l1.addLast(2);
//		l1.addLast(4);
//		l1.addLast(15);
//		l1.addLast(6);
//		l1.addLast(1);
//		l1.addLast(3);
//		l1.addLast(13);
//		l1.printList();
//		System.out.println();
//		l2.addLast(4);
//		l2.addLast(5);
//		l2.addLast(7);
//		ListNode n = l1.nthFromEndRecursive(3);
//		l2.tail.next = n;
//		l2.tail = l1.tail;
//		l2.printList();
//		System.out.println();
//		ListNode intersection = findIntersectionPointUsingLenDiff(l1, l2);
//		System.out.println("The intersection node is " + ((intersection != null) ? intersection.data : null));
//		System.out.println("Merging these two lists");
//		ListNode merged = mergeSortedLists(l1, l2);
//		l1.setHead(merged);
//		l1.printList();
//		MyLinkedList l1 = new MyLinkedList();
//		l1.addLast(9);
//		l1.addLast(9);
//		l1.addLast(1);
//		l1.addLast(7);
//		l1.addLast(1);
//		MyLinkedList l2 = new MyLinkedList();
//		l2.addLast(9);
//		l2.addLast(9);
//		l2.addLast(8);
//		MyLinkedList result = new MyLinkedList();
//		result.head = result.addTwoLinkedListNumbersInNaturalOrderUsingStacks(l1.head, l2.head);
//		System.out.println("Addition of two Linked Lists");
//		l1.printList();
//		System.out.println();
//		System.out.println("------- +---------- ");
//		l2.printList();
//		System.out.println();
//		result.printList();
	
//		MyLinkedList rl1 = new MyLinkedList();
//		MyLinkedList rl2 = new MyLinkedList();
//		MyLinkedList rresult = new MyLinkedList();
//		rl1.addLast(7);
//		rl1.addLast(8);
//		rl1.addLast(9);
//		rl1.addLast(4);
//		rl1.addLast(6);
//        rl2.addLast(8);
//        rl2.addLast(2);
//        rresult.addTwoLinkedListNumbersInReverseOrder(rl1.head, rl2.head);
//        System.out.println("Addition of two Linked List Numbers represented in Reverse Order");
//        rl1.printList();
//        System.out.println();
//        System.out.println("------+-------");
//        rl2.printList();
//        System.out.println();
//        rresult.printList();
//		MyLinkedList l1 = new MyLinkedList();
//		l1.addLast(9);
//		l1.addLast(9);
//		l1.addLast(6);
//		l1.addLast(4);
//		l1.addLast(6);
//		MyLinkedList l2 = new MyLinkedList();
//		l2.addLast(9);
//		l2.addLast(3);
//		l2.addLast(5);
//		l2.addLast(3);
//		MyLinkedList addList = new MyLinkedList();
//		addList.addTwoLinkedListNumbersInNaturalOrderRecursive(l1.head,l2.head);
//		System.out.println("Adding two linked list numbers in natural order recursive");
//		l1.printList();
//		System.out.println();
//		System.out.println("-----------+--------------");
//		l2.printList();
//		System.out.println();
//		addList.printList();
//		System.out.println();
		MyLinkedList l1 = new MyLinkedList();
		l1.addLast(1);
		l1.addLast(2);
		l1.addLast(9);
		l1.addLast(4);
//		l1.addLast(4);
		l1.addLast(3);
		l1.addLast(2);
		l1.addLast(1);
		l1.printList();
		System.out.println();
		System.out.println(l1.getSize());
		System.out.println("Is Palindrome ? " + l1.isPalindromeRecursive());
}
}