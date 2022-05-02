function solve(matrix) {
    let mainDiagonalSum = 0;
    let secondaryDiagonalSum = 0;
    let countMain = 0;
    let countSecondary = matrix.length - 1;
    for (const row of matrix) {
        secondaryDiagonalSum += row[countSecondary]
        mainDiagonalSum += row[countMain];
        countMain++;
        countSecondary--;
    }
    console.log(mainDiagonalSum + ' ' + secondaryDiagonalSum);
}

solve([[3, 5, 17],
    [-1, 7, 14],
    [1, -8, 89]]);