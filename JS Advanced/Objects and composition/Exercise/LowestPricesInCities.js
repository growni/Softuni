function solve(array) {
    let towns = [];
    for (const line of array) {
        
        let [town, product,price] = line.split(' | ');
        
        if(towns.filter(t => t.product === product).length > 0) {
            let obj = towns.find(t => t.product === product);
            
            if(Number(price) < obj.price) {
                obj.town = town;
                obj.price = Number(price);
            }
        } else {
            let obj = {
                town, product, price
            }
            towns.push(obj);
        }
    }
    for (const town of towns) {
        console.log(`${town.product} -> ${town.price} (${town.town})`);
    }
    
}

solve(['Sofia City | Audi | 100000',
'Sofia City | BMW | 100000',
'Mexico City | BMW | 99999',
]);