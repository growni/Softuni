function solve(array) {
    let index = 0;
    let filteredArray = [];
    for (const item of array) {
        if(index % 2 != 0) {
            filteredArray.push(item);
        }
        index++;
    }
    console.log(filteredArray.map(a => a * 2).reverse().join(' '));
}

solve([3, 0, 10, 4, 7, 3]);