function solve(number) {
    
    let numberAsText = number + '';
    let array = numberAsText.split('');
    let compare = array[0];
    let areNumbersTheSame = true;
    
    let sum = 0;
    let current;
    while (number >= 1) {
        current = parseInt(number % 10);
        if(current != compare) {
            areNumbersTheSame = false;
        }
        sum += current;
        parseInt(number /= 10);
    }
    console.log(areNumbersTheSame);
    console.log(sum);
}
solve(1234);