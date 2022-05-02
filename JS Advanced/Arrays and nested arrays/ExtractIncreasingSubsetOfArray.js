function solve(array) {
    let biggestValue = Number.MIN_SAFE_INTEGER;
    let updatedArray = [];
    for (const number of array) {
        if (number >= biggestValue) {
            updatedArray.push(number);
            biggestValue = number;
        }
    }
    return updatedArray;
}

solve([20,
    3,
    2,
    15,
    6,
    1]);