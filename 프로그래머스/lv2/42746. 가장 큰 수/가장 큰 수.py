from functools import cmp_to_key

def solution(numbers):
    #배열 -> 문자열
    numbers = list(map(str, numbers))
    #내림차순 정렬 및 예외케이스 0 제거
    numbers.sort(key=cmp_to_key(lambda x, y : int(x+y) - int(y+x)), reverse=True)
    
    return str(int(''.join(numbers)))
