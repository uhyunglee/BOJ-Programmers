def solution(new_id):
    answer = ''
    #1
    new_id = new_id.lower()
    #2
    for ch in new_id:
        if ch.isalpha() or ch.isdigit() or ch in '-_.':
            answer += ch
    #3
    while '..' in answer:
        answer = answer.replace('..', '.')
    #4
    if answer and answer[0] == '.':
        answer = answer[1:]
    if answer and answer[-1] == '.':
        answer = answer[:-1]
    #5
    if answer == '':
        answer = 'a'
    #6
    answer = answer[:15]
    if answer[-1] == '.':
        answer = answer[:-1]
    #7
    while len(answer) < 3:
        answer += answer[-1]
        
    return answer