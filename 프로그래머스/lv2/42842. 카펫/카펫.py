def solution(brown, yellow):
    for width in range(3, 5001):
        for height in range(3, width + 1):
            boundary = (width + height - 2) * 2
            center = width * height - boundary

            if brown == boundary and yellow == center:
                return [width, height]

    return None