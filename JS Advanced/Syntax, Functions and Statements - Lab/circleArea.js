function findCircleArea(input) {
    let inputType = typeof(input);
    if(inputType != 'number') {
        console.log('We can not calculate the circle area, because we receive a ' + inputType + '.');
    } else {
        let result =  Math.PI * (input ** 2);
        console.log(result.toFixed(2));
    }
}
findCircleArea(5);