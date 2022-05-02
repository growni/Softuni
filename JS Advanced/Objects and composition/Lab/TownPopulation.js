function solve(array) {
    let towns = {};

    for (const each of array) {
        let data = each.split(' <-> ')
        let name = data[0];
        let population = Number(data[1]);
        if(towns[name] > 0) {
            towns[name] += population;
        } else {
            towns[name] = population;
        }
    }
    for (const town in towns) {
        console.log(`${town} : ${towns[town]}`);
    }
}

solve(['Istanbul <-> 100000',
'Honk Kong <-> 2100004',
'Jerusalem <-> 2352344',
'Mexico City <-> 23401925',
'Istanbul <-> 1000']);