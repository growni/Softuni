function sumOfNumbers(num1, num2) {
    let sum = 0;
    let a = Number(num1);
    let b = Number(num2);
    for (let i = a; i <= b; i++) {
        sum += i;
    }
    console.log(sum);
}
sumOfNumbers('-8', '20')