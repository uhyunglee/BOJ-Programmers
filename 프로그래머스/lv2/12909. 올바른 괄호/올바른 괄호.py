def solution(s):
    answer = True
    stack = []

    for str in s:
        if not stack and str == ')': return False
        elif str == '(': stack.append('(')
        elif str == ')': stack.pop()
    if stack: return False

    return True