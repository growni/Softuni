function solve(input) {
    input.sort();
    let startLetter = input[0][0];
    console.log(startLetter);
    function productToString(product) {
        return product.name + ': ' + product.price;
    }
    for (const line of input) {
        let [name, price] = line.split(' : ');
        let product = { name, price };
        
        if (line[0] != startLetter) {
            console.log(line[0]);
            console.log('  ' + productToString(product));
            startLetter = line[0];
        } else {
            console.log('  ' + productToString(product));
        }
    }
}

solve(['Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10']
);