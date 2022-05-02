function solve(number) {
    
    let numberAsText = number + '';
    let array = numberAsText.split('');
    let compare = array[0];
    let areNumbersTheSame = true;
    for (let i = 0; i < array.length; i++) {
        if (array[i] != compare) {
            areNumbersTheSame = false;
            break;
        }
    }
    let sum = 0;
    while (number >= 1) {
        sum += parseInt(number % 10);
        parseInt(number /= 10);
    }
    console.log(areNumbersTheSame);
    console.log(sum);
}
solve(1234);