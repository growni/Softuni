function findGreatestCommonDivisor(a, b) {
    if(b != 0) {
        return findGreatestCommonDivisor(b, a % b);
    } else {
        console.log(a);
    }
}
findGreatestCommonDivisor(15, 5);
findGreatestCommonDivisor(2154, 458);

