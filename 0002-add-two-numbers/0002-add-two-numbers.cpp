/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
        ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int n1=0 ,n2=0 ,sum=0 ,carry=0;
        ListNode *iterator ,*ans;
        iterator = new ListNode();
        ans = iterator;
        while (l1 != nullptr || l2 != nullptr){
            if (l1 != nullptr)
                n1 = l1->val;
            else
                n1 = 0;
            if (l2 != nullptr)
                n2 = l2->val;
            else
                n2 = 0;
            sum = n1 + n2 + carry;
            cout << "sum : " << sum << '\n';
            iterator->val = (sum % 10);
            carry = sum / 10;
            cout << "carry : " << carry << '\n';
            if (l1 != nullptr)
                l1 = l1->next;
            if (l2 != nullptr)
                l2 = l2->next;
            
            if (l1 != nullptr || l2 != nullptr){
                iterator->next = new ListNode();
                iterator = iterator->next;
            }
        }
        if (carry)
            iterator->next = new ListNode(carry);
        return ans;
    }
};