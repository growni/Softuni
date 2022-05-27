function solve(array) {
    let sortedArray = array.sort((a, b) => {
        if (a.length == b.length) {
           return a.toLowerCase().localeCompare(b.toLowerCase());
        } else {
            return a.length - b.length;
        }
    });
    sortedArray.forEach(element => {
        console.log(element);
    });

}

solve(['Isacc', 
'Theodor', 
'Jack', 
'Harrison', 
'George']
);