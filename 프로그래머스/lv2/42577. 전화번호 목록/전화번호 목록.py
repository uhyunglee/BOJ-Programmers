def solution(phone_book):
    hash_map = {}
    for phone_number in phone_book:
        hash_map[phone_number] = 1

    for phone_number in phone_book:
        for i in range(len(phone_number)):
            prefix = phone_number[:i]
            if prefix in hash_map and prefix != phone_number:
                return False
    return True
