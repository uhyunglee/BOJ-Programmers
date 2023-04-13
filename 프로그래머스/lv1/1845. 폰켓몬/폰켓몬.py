def solution(nums):
    answer = 0
    ponketmon = set(nums)
    if len(nums)/2 > len(ponketmon):
        answer = len(ponketmon)
    else:
        answer = len(nums)/2
    return answer