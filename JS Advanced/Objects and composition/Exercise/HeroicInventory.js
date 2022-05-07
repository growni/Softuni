function solve(array) {
    let heroData = [];

    for (const line of array) {
        let splittedLine = line.split(' / ');
        let hero = {
            name: splittedLine[0],
            level: Number(splittedLine[1]),
            items: []
        }
        if (splittedLine.length == 3) {
            let items = splittedLine[2].split(', ');
            for (const item of items) {
                hero.items.push(item);
            }
        }
        heroData.push(hero);
    }
    console.log(JSON.stringify(heroData));
}

solve(['Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara']);