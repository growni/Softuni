function solve(firstInput, secondInput, thirdInput) {
    let firstLength = firstInput.length;
    let secondLength = secondInput.length;
    let thirdLength = thirdInput.length;
    let sum = firstLength + secondLength + thirdLength;
    let average = Math.floor(sum / 3);
    console.log(sum);
    console.log(average);
}
solve('chocolate', 'ice cream', 'cake');