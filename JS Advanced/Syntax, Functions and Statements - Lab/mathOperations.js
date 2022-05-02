function solve(a, b, operator) {
    let result = 0;
    switch (operator) {
        case '+':
            console.log(a + b);
            break;
        case '-':
            console.log(a - b);
            break;
        case '*':
            console.log(a * b);
            break;
        case '/':
            console.log(a / b);
            break;
        case '%':
            console.log(a % b);
            break;
        case '**':
            console.log(a ** b);
            break;
    }
}
solve(3, 5.5, '*');
