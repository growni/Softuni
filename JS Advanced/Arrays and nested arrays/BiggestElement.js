function solve(array) {
    let biggestNum = Number.MIN_SAFE_INTEGER;
    for (const row of array) {
        for (const col of row) {
            if (col > biggestNum) {
                biggestNum = col;
            }
        }
    }
    return biggestNum;
}

solve([[3, 5, 7, 12],
    [-1, 4, 33, 2],
    [8, 3, 0, 4]]);