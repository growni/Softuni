function solve(arrayInput, step) {
    let countStep = 0;
    let finalArray = [];
    finalArray.push(arrayInput[0]);
    
    for(let i = 0; i < arrayInput.length; i++) {
        if(countStep == step) {
            finalArray.push(arrayInput[i]);
            countStep = 0;
        }
        countStep++;
    }
    return finalArray;
}

solve(['1', 
'2',
'3', 
'4', 
'5'], 
6)