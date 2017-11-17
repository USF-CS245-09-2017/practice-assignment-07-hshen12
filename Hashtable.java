
public class Hashtable {

	class HashNode {
		private String key;
		private String value;
		private HashNode next;
		
		public HashNode(String key, String value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
	private HashNode[] arr;
	
	public Hashtable() {
		this.arr = new HashNode[10000];

	}
	
	public void put(String key, String val) {
		int position = Math.abs(key.hashCode()) % arr.length;
		HashNode head = arr[position];
		HashNode node = new HashNode(key, val);
		node.next = head;
		arr[position] = node;
		
	}

	public Object get(String key) {
		int position = Math.abs(key.hashCode()) % arr.length;
		HashNode head  = arr[position];
		
		while(head != null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	public String remove(String key) {
		int position = Math.abs(key.hashCode()) % arr.length;
		HashNode head = arr[position];
		
		if(head.key.equals(key)) {
			arr[position] = head.next;
			return head.value;
		}
		
		HashNode prev = head;
		while(head != null) {
			if(head.key.equals(key)) {
				prev.next = head.next;
				return head.value;
			}
			prev = head;
			head = head.next;
		}
		return null;
		
		
	}

	public boolean containsKey(String key) {
		return arr[Math.abs(key.hashCode()) % arr.length] != null;
	}

}
