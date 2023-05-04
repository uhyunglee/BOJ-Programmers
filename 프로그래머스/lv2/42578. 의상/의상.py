def solution(clothes):
    answer = 0
    clothes_hash = {}
    for i in range(len(clothes)) :
        if clothes[i][1] in clothes_hash :
            clothes_hash[clothes[i][1]] += 1
        else :
            clothes_hash[clothes[i][1]] = 1
    count = []
    value = 1
    for i in clothes_hash.values() :
        count.append(i)
    for i in count :
        value *= i + 1
    return value - 1