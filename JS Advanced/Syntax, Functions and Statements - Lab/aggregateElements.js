function solve(array) {
    let arrayNumbers = array.map(Number);
    let sum = arrayNumbers.reduce((a, b) => a + b);
    let inverseSum = 0.0;
    array.forEach(element => {
        inverseSum += 1 / element;
    });
    let concat = arrayNumbers.join('');
    
    console.log(sum);
    console.log(inverseSum);
    console.log(concat);
}

solve([1, 2, 3]);
solve([2, 4, 8, 16]);