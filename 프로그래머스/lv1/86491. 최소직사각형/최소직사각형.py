def solution(sizes):
    a, b = 0, 0
    for w, h in sizes:
        if w < h:
            w, h = h, w
        a = max(a, w)
        b = max(b, h)
    return a*b