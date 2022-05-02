function solve(matrix) {
    let sum = matrix[0].reduce((a, b) => a + b, 0);
    let checkSum = sum;
    let rows = matrix.length;
    //check all rows
    for (let row = 0; row < rows; row++) {
        checkSum = matrix[row].reduce((a, b) => a + b, 0);
        if (checkSum != sum) {
            return false;
        }
    }
    //extract a column from the matrix
    function getCol(matrix, col) {
        let column = [];
        for (let i = 0; i < rows; i++) {
            column.push(matrix[i][col]);
        }
        return column;
    }
    //check all columns
    for (let row = 0; row < rows; row++) {
        checkSum = 0;
        let column = getCol(matrix, row);
        checkSum = column.reduce((a, b) => a + b, 0);
        if (checkSum != sum) {
            return false;
        }
    }
    return true;
}

console.log(solve([[4, 5, 6],
[6, 5, 4],
[5, 5, 5]]));