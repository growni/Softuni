function solve(array) {
    let board = [];
    board[0] = ['false', 'false', 'false'];
    board[1] = ['false', 'false', 'false'];
    board[2] = ['false', 'false', 'false'];
    let firstPlayerWin = ['X', 'X', 'X'];
    let secondPlayerWin = ['O', 'O', 'O'];
    let firstPlayer = 'X';
    let secondPlayer = 'O';
    let rows = 3;
    function printBoard(board) {
        for (let row = 0; row < rows; row++) {
            console.log(board[row].join('	'));
        }
    }
    function getCol(board, col) {
        let column = [];
        for (let i = 0; i < rows; i++) {
            column.push(board[i][col]);
        }
        return column;
    }


    function getDiagonals(board) {
        let diagonals = [];
        let LeftDiagonal = [];
        let rightDiagonal = [];
        for (let row = 0; row < rows; row++) {
            LeftDiagonal.push(board[row][row]);
        }
        diagonals.push(LeftDiagonal);
        let count = 0;
        for (let row = rows - 1; row >= 0; row--) {
            let symbol = board[count][row];
            rightDiagonal.push(symbol);
            count++;
        }
        diagonals.push(rightDiagonal);
        return diagonals;
    }

    let playerSwitch = 'X';
    for (let move = 0; move < array.length; move++) {
        let coordinates = array[move];
        let row = coordinates.split(' ')[0];
        let col = coordinates.split(' ')[1];

        //check if game ended without a winner
        function noWinner(board) {
            for (const row of board) {
                if (row.includes('false')) {
                    return false;
                }
            }
            return true;
        }
        if (noWinner(board)) {
            break;
        }

        //switch players and check if place is already taken
        if (playerSwitch == 'X') {
            if (board[row][col] == 'false') {
                board[row][col] = 'X';
            } else {
                console.log('This place is already taken. Please choose another!');
                continue;
            }
            playerSwitch = 'O';
        } else {
            if (board[row][col] == 'false') {
                board[row][col] = 'O';
            } else {
                console.log('This place is already taken. Please choose another!');
                continue;
            }
            playerSwitch = 'X';
        }

        //check all rows
        for (let row = 0; row < rows; row++) {
            if (JSON.stringify(board[row]) == JSON.stringify(firstPlayerWin) || JSON.stringify(board[row]) == JSON.stringify(secondPlayerWin)) {
                if (JSON.stringify(board[row]) == JSON.stringify(firstPlayerWin)) {
                    console.log(`Player ${firstPlayer} wins!`);
                    printBoard(board);
                    return;
                } else if (JSON.stringify(board[row]) == JSON.stringify(secondPlayerWin)) {
                    console.log(`Player ${secondPlayer} wins!`);
                    printBoard(board);
                    return;
                }
            }
        }
        //check all columns
        for (let row = 0; row < rows; row++) {
            let col = getCol(board, row);
            if (JSON.stringify(col) == JSON.stringify(firstPlayerWin) || JSON.stringify(col) == JSON.stringify(secondPlayerWin)) {
                if (JSON.stringify(col) == JSON.stringify(firstPlayerWin)) {
                    console.log(`Player ${firstPlayer} wins!`);
                    printBoard(board);
                    return;
                } else if (JSON.stringify(col) == JSON.stringify(secondPlayerWin)) {
                    console.log(`Player ${secondPlayer} wins!`);
                    printBoard(board);
                    return;
                }
            }
        }
        //check diagonals
        let diagonals = [];
        diagonals = getDiagonals(board);
        let LeftDiagonal = [];
        LeftDiagonal = diagonals[0];
        let rightDiagonal = [];
        rightDiagonal = diagonals[1];

        if (JSON.stringify(LeftDiagonal) == JSON.stringify(firstPlayerWin) || JSON.stringify(rightDiagonal) == JSON.stringify(firstPlayerWin)) {
            console.log(`Player ${firstPlayer} wins!`);
            printBoard(board);
            return;
        } else if (JSON.stringify(LeftDiagonal) == JSON.stringify(secondPlayerWin) || JSON.stringify(rightDiagonal) == JSON.stringify(secondPlayerWin)) {
            console.log(`Player ${secondPlayer} wins!`);
            printBoard(board);
            return;
        }

    }
    console.log('The game ended! Nobody wins :(');
    printBoard(board);
}

// solve(["0 1",
//     "0 0",
//     "0 2",
//     "2 0",
//     "1 0",
//     "1 1",
//     "1 2",
//     "2 2",
//     "2 1",
//     "0 0"]);

// solve(["0 0",
//     "0 0",
//     "1 1",
//     "0 1",
//     "1 2",
//     "0 2",
//     "2 2",
//     "1 2",
//     "2 2",
//     "2 1"]);

// solve(["0 1",
//     "0 0",
//     "0 2",
//     "2 0",
//     "1 0",
//     "1 2",
//     "1 1",
//     "2 1",
//     "2 2",
//     "0 0"]);

// test inputs
// solve(["0 0", "1 0", "1 1", "2 0", "2 2"]);