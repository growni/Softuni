function solve(array) {
    array.sort((a, b) => a.localeCompare(b));
    let count = 1;
    for (const name of array) {
        console.log(count + '.' + name);
        count++;
    }
}

solve(["John", "Bob", "Christina", "Ema"]);