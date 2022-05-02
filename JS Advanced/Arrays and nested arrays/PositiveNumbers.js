function solve(array) {
    let sortedArray = [];
    for (const number of array) {
        if (number < 0) {
            sortedArray.unshift(number);
        } else {
            sortedArray.push(number);
        }
    }
    for (const number of sortedArray) {
        console.log(number);
    }
}
solve([7, -2, 8, 9]);
solve([3, -2, 0, -1]);