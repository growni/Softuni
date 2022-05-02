function solve(array) {
    let evenNumbers = [];
    for (const number of array) {
        if (array.indexOf(number) % 2 == 0) {
            evenNumbers.push(number);
        }
    }
    console.log(evenNumbers.join(' '));
}
solve(['20', '30', '40', '50', '60']);