/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev=head;
        ListNode curr=head.next;
        int pos=2;
        int first=-1;
        int prevcritical=-1;
        int min=Integer.MAX_VALUE;
        int last=-1;
        while (curr != null && curr.next != null) {
            ListNode next=curr.next;
            boolean iscritic=(curr.val<prev.val&&curr.val<next.val)||(curr.val>prev.val&&curr.val>next.val);
            if(iscritic){
                if(first==-1){
                    first=pos;
                    prevcritical=pos;
                }
                else{
                    min=Math.min(min,pos-prevcritical);
                    prevcritical=pos;
                }
                  last=pos;
            }
            prev=curr;
            curr=curr.next;
            pos++;
        }
         if (first == -1 || first == last) {
            return new int[] {-1, -1};
        }
        int max=last-first;
        return new int[]{min,max};
    }
}