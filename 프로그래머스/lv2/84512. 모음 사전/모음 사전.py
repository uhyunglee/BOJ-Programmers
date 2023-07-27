from itertools import product
 
def solution(word):
    word_dic = set()
    for p in product(["", "A", "E", "I", "O", "U"], repeat = 5):
        word_dic.add("".join(p))
    word_dic = sorted(word_dic)
    for idx, w in enumerate(word_dic):
        if w == word:
            return idx