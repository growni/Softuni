function solve(array) {
    let arr = [];
    //   arr.length = array.length;
    let number = 0;
    for (const command of array) {
        switch (command) {
            case 'add':
                number++;
                arr.push(number);
                break;
            case 'remove':
                number++;
                arr.pop();
                break;
        }
    }
    if (arr.length == 0 ? console.log('Empty') : arr.forEach(number => console.log(number))) {
        
    } 
}

solve(['add',
    'add',
    'remove',
    'add',
    'add']);