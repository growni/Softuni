function solve(n, k) {
    let array = [];
    array[0] = 1;
    array[1] = 1;
    array[2] = 2;
    let sum = 0;
    let slicedArray;
    let sliceFrom;
    for (let i = 3; i < n; i++) {
        if (k > i) {
            sliceFrom = 0;
        } else {
            sliceFrom = i - k;
        }
        slicedArray = array.slice(sliceFrom, array.length);
        sum = slicedArray.reduce(function (acc, curr) {
            return acc + curr;
        });
        array[i] = sum;
    }
    
    return array;
}
solve(6, 3);