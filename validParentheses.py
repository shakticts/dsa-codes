class Solution(object):
    def isValid(self, s):
       stack=[]
       bracket_map={")":"(","}":"{","]":"["}
       for char in s:

        if char in bracket_map.values():
            stack.append(char)
        else:
            if not stack or stack[-1] != bracket_map[char]:
                return False
            stack.pop()    
       return not stack    
