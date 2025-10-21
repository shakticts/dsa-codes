class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        int i = 0, j = 0;           // pointers for s and p
        int lastStar = -1;          // position of last '*' in p
        int match = 0;              // position in s where we started matching after last '*'

        while (i < n) {
            // match single character or '?'
            if (j < m && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++; j++;
            }
            // record star position and try to match zero characters for now
            else if (j < m && p.charAt(j) == '*') {
                lastStar = j;
                match = i;
                j++; // move pattern pointer past '*'
            }
            // if mismatch but we previously saw a '*', backtrack:
            // let '*' consume one more char from s
            else if (lastStar != -1) {
                j = lastStar + 1;
                match++;
                i = match;
            }
            // mismatch and no previous '*' to adjust -> fail
            else {
                return false;
            }
        }

        // skip any trailing '*' in pattern (they can match empty sequence)
        while (j < m && p.charAt(j) == '*') j++;

        return j == m;
    }
}
