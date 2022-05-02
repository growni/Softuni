function solve(array) {
    let sortedArray = array.sort((a, b) => a - b);
    let startIndex = Math.floor(sortedArray.length / 2);
    let biggerHalf = sortedArray.slice(startIndex);
    return biggerHalf;
}

solve([4, 7, 2, 5]);
solve([3, 19, 14, 7, 2, 19, 6]);