import heapq

def solution(operations):
    max_heap = []  
    min_heap = []

    for operation in operations:
        op, num = operation.split()
        num = int(num)

        if op == "I":
            heapq.heappush(max_heap, -num)
            heapq.heappush(min_heap, num)
        elif op == "D":
            if not max_heap:
                continue

            if num == 1:
                max_value = heapq.heappop(max_heap)
                min_heap.remove(-max_value)
            elif num == -1:
                min_value = heapq.heappop(min_heap)
                max_heap.remove(-min_value)

    if not max_heap:
        return [0, 0]

    return [-heapq.heappop(max_heap), heapq.heappop(min_heap)]
