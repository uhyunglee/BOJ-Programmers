#include <iostream>
#include <algorithm>
using namespace std;

int array1[500001] = {0,};
int array2[500001] = {0,};

void binarysearch(int N, int k){
    int low = 0;
    int high = N-1;

    while(low <= high){
        int mid = (low + high) / 2;
        if(array1[mid] == k){
            cout << "1" << "\n";
            return;
        }else{
            if(array1[mid] > k){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
    }
    cout << "0" << "\n";
}
int main() {
    int N,M;
    cin >> N;
    for(int i=0;i<N;i++){
        cin >> array1[i];
    }
    
    cin >> M;
    for(int i=0;i<M;i++){
        cin >> array2[i];
    }

    sort(array1, array1+N);

    for(int i=0;i<M;i++){
        binarysearch(N, array2[i]);
    }
}
