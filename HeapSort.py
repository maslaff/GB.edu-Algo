def sort(arr):
    for i in range(int(len(arr)/2-1), -1, -1):
        heapify(arr, len(arr), i)

    for n in range(len(arr)-1, -1, -1):
        arr[0], arr[n] = arr[n], arr[0]
        heapify(arr, n, 0)

    return arr


def heapify(arr, heapSize, rootIndex):
    largest = rootIndex
    lChild = 2 * rootIndex + 1
    rChild = 2 * rootIndex + 2

    if lChild < heapSize and arr[lChild] > arr[largest]:
        largest = lChild

    if rChild < heapSize and arr[rChild] > arr[largest]:
        largest = rChild

    if largest != rootIndex:
        arr[rootIndex], arr[largest] = arr[largest], arr[rootIndex]
        heapify(arr, heapSize, largest)


a = [3, 5, 7, 1, 9, 6, 2, 4, 8]

print(sort(a))
