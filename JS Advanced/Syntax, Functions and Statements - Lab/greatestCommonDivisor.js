function findGreatestCommonDivisor(num1, num2) {
    if(num2 != 0) {
        return findGreatestCommonDivisor(num2, num1 % num2);
    } else {
        console.log(num1);
    }
}
findGreatestCommonDivisor(15, 5);
findGreatestCommonDivisor(2154, 458);

