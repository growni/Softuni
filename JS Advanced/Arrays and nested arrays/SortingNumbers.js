function solve(array) {
    array.sort((a, b) => {
        return a - b;
    });
    let reformedArray = [];
    while (array.length > 0) {
        reformedArray.push(array.shift());
        reformedArray.push(array.pop());
    }
    return reformedArray;
}

solve([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]);