def solution(array, commands):
    answer = []
    newArray = []
    
    for i in commands:
        newArray = commands[i][0] - 1, commands[i][1]
        sorted(newArray)
        answer[i] = newArray[commands[i][2] - 1]
    return answer

