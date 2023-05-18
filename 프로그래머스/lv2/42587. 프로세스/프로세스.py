def solution(priorities, location):
    count = 0
    pre = -1
    goal = priorities[location]
    length = len(priorities)

    for i in range(9,0,-1):
        if i not in priorities:
            continue

        if goal == i and pre == -1:
            count = priorities[0:location + 1].count(i)
            return count

        for j in range(pre,pre+length):
            if priorities[j%length] == i:     
                count += 1
                pre = j % length
            if i == goal and j%length == location:
                return count