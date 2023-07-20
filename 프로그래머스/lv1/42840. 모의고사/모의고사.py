def solution(answers):
    answer = []
    arr1 = [1,2,3,4,5]
    arr2 = [2,1,2,3,2,4,2,5]
    arr3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    score = [0, 0, 0]
    for i, a in enumerate(answers):
        if a == arr1[i%len(arr1)]:
            score[0] += 1
        if a == arr2[i%len(arr2)]:
            score[1] += 1
        if a == arr3[i%len(arr3)]:
            score[2] += 1
    _max = max(score)
    for i, s in enumerate(score):
        if s == _max:
            answer.append(i+1)
    return answer