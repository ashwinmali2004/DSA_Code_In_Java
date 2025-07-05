package LinkedList;

public class Questions {
    // 876 leetcode
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // pairwise swap elements gfg
    public Node pairwiseSwap(Node head) {
        if(head==null) return head;
        Node first = head;
        Node prev = null;
        while(first!=null && first.next!=null){
            Node second = first.next;
            first.next = second.next;
            second.next = first;
            if(prev==null){
                head=second;
            }else{
                prev.next=second;
            }
            prev=first;
            first=first.next;
        }
        return head;
    }

    // 2 leetocode
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode res = ans;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry=0;
        while(temp1!=null && temp2!=null){
            int sum = temp1.val+temp2.val+carry;
            int unit = sum%10;
            carry = sum/10;
            ListNode newNode = new ListNode(unit);
            res.next = newNode;
            res = res.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while(temp1!=null){
            int sum = temp1.val+carry;
            int unit = sum%10;
            carry = sum/10;
            ListNode newNode = new ListNode(unit);
            res.next = newNode;
            temp1 = temp1.next;
            res = res.next;
        }

        while(temp2!=null){
            int sum = temp2.val+carry;
            int unit = sum%10;
            carry = sum/10;
            ListNode newNode = new ListNode(unit);
            res.next = newNode;
            temp2 = temp2.next;
            res = res.next;
        }

        if(carry>0){
            ListNode newNode = new ListNode(carry);
            res.next = newNode;
            res = res.next;
        }

        return ans.next;
    }

    // 206 Leetcode Reverse a Linked List
    public ListNode reverseList(ListNode head) {
        // Iterative-> O(n)
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    // 141 Leetcode
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    // 142 Leetcode
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) break;
        }
        if(fast==null|| fast.next==null){
            return null;
        }
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // 2095 leetcode
    public ListNode deleteMiddle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev==null){
            return null;
        }
        prev.next = slow.next;
        slow.next = null;
        return head;
    }

    // 234 palindrome
        public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode first = head;
        ListNode second = reverse(slow);
        while(second != null){
            if(first.val != second.val){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}
