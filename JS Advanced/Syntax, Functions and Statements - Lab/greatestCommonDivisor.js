function findGreatestCommonDivisor(num1, num2) {
    let loopLength = num1 > num2 ? num1:num2;
    let greatestDivisor = 0;
    for(let i = 0; i <= loopLength; i++) {
        if(num1 % i == 0 && num2 % i == 0) {
            greatestDivisor = i;
        }
    }
    console.log(greatestDivisor);
}
findGreatestCommonDivisor(15, 5);
findGreatestCommonDivisor(2154, 458);

