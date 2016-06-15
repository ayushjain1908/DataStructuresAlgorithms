import java.util.*;
public class LRUcache {

	private DLList pageList;
	private HashMap<Integer,DLNode> pageMap;
	private int cacheSize;
	public LRUcache(int size){
		cacheSize = size;
		pageList = new DLList(size);
		pageMap = new HashMap<Integer,DLNode>();
	}
	public void accessPage(int pageNo){
		if(pageMap.containsKey(pageNo)){
			DLNode pageNode = pageMap.get(pageNo);
			pageList.moveToHead(pageNode);
		}
		else{
			if(pageList.currSize == cacheSize){
				pageMap.remove(pageList.tail.pageNo);
			}
			DLNode pageNode = pageList.addToHead(pageNo);
			pageMap.put(pageNo,pageNode);
		}
		
	}
	public void printCacheState(){
		pageList.printList();
	}
	class DLList{
		private int size;
		private int currSize;
		private DLNode head;
		private DLNode tail;
		public DLList(int size){
			this.size  = size;
		}
		public void moveToHead(DLNode node){
			if(node == null || head == node){
				return;
			}
			if(node == tail){
				node.prev.next = null;
				tail = tail.prev;
			}
			DLNode next = node.next;
			DLNode prev = node.prev;
			prev.next = next;
			if(next != null){
				next.prev = prev;
			}
			node.prev = null;
			node.next = head;
			head.prev = node;
			head = node;
			
		}
		public DLNode addToHead(int pageNo){
			DLNode node = new DLNode(pageNo);
			if(currSize < size){
				currSize++;
			}
			else{
				tail.prev.next = null;
				tail = tail.prev;
			}
			if(head == null){
				head = node;
				tail = node;
			}
			else{
				head.prev = node;
				node.next = head;
				head = node;
			}
			return node;
			
		}
		public void printList(){
		    DLNode i = head;
			while(i != null){
			 	System.out.print(i.pageNo + "->");
			 	i = i.next;
			}
			System.out.println();
		}
	}
	class DLNode{
		private int pageNo;
		private DLNode next;
		private DLNode prev;
		public DLNode(int pageNo){
			this.pageNo = pageNo;
		}
	}
	public static void main(String[] args) {
		LRUcache cache = new LRUcache(4);
		cache.accessPage(2);
		cache.printCacheState();
		cache.accessPage(4);
		cache.printCacheState();
		cache.accessPage(1);
		cache.printCacheState();
		cache.accessPage(3);
		cache.printCacheState();
		cache.accessPage(2);
		cache.printCacheState();
		cache.accessPage(6);
		cache.printCacheState();
		cache.accessPage(2);
		cache.printCacheState();
		cache.accessPage(2);
		cache.printCacheState();
		cache.accessPage(8);
		cache.printCacheState();
		cache.accessPage(6);
		cache.printCacheState();
		cache.accessPage(7);
		cache.printCacheState();
	}
}
