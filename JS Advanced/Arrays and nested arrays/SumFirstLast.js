function solve(array) {
    let sum;
    let lastNum = Number(array.pop());
    let firstNum = Number(array.shift());
    sum = lastNum + firstNum;
    return sum;
}
solve(['20', '30', '40']);
solve(['-1', '2', '-3']);
solve(['5', '10']);
solve(['10', '20', '30', '40', '50']);