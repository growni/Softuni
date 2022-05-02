function solve(array) {
    let sortedArray = array.sort((a, b) => a -b);
    console.log(sortedArray[0] + ' ' + sortedArray[1]);
}
solve([3, 0, 10, 4, 7, 3]);