function solve(arrayInput, step) {
    return arrayInput.filter((element, index) => index % step == 0);
}
solve(['1', 
'2',
'3', 
'4', 
'5'], 
6)