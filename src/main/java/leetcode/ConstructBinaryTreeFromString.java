class Solution {
   public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0)
            return null;
        return findEnd(s, 0, s.length());        
    }
    
    private TreeNode findEnd(String str, int begin, int end){
        if (begin > end)
            return null;
        if (str.indexOf('(') == -1)
            return new TreeNode(Integer.valueOf(str));
        
        StringBuilder sb = new StringBuilder();
        if (str.charAt(begin) == '-'){
            sb.append(str.charAt(begin++));
        }
        while (Character.isDigit(str.charAt(begin))){
            sb.append(str.charAt(begin++));
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(sb.toString()));
        int l = getIndex(str, begin, end);
        root.left = findEnd(str, begin+1, l-1);
        root.right = findEnd(str, l+2, end-1);
        return root;
    }
    
    private int getIndex(String str, int begin, int end){
        int count = 0;
        int l = begin;
        for (; l < end; ++l){
            if (str.charAt(l) == '('){
                count++;
            } else {
                if (str.charAt(l) == ')'){
                    count--;
                    if (count == 0)
                        break;
                }
            }
        }
        return l;
    }
}
