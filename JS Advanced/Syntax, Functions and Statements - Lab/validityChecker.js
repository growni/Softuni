function validityChecker(x1, y1, x2, y2) {
    function calculate(x1, y1, x2, y2) {
        let distanceX = x1 - x2;
        let distanceY = y1 - y2;
        return Math.sqrt(distanceX ** 2 + distanceY ** 2);
    }
    //x1, y1 to 0, 0
    if(Number.isInteger(calculate(x1, y1, 0, 0))) {
        console.log(`{${x1}, ${y1}} to {0, 0} is valid`);
    } else {
        console.log(`{${x1}, ${y1}} to {0, 0} is invalid`);
    }
    //x2, y2 to 0, 0
    if(Number.isInteger(calculate(x2, y2, 0, 0))) {
        console.log(`{${x2}, ${y2}} to {0, 0} is valid`);
    } else {
        console.log(`{${x2}, ${y2}} to {0, 0} is invalid`);
    }
    //x1, y1 to x2, y2
    if(Number.isInteger(calculate(x1, y1, x2, y2))) {
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is valid`);
    } else {
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`);
    }
}
// validityChecker(3, 0, 0, 4);
validityChecker(2, 1, 1, 1);

