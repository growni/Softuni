function solve(name, population, treasury) {
    let taxRate = 10;
    let city = {
        name: name,
        population: population,
        treasury: treasury,
        taxRate,
        collectTaxes: function () {
            this.treasury += taxRate * population;
        },
        applyGrowth: function (percentage) {
            this.population = Math.floor(this.population * (percentage / 100 + 1));
        },
        applyRecession: function (percentage) {
            this.treasury -= Math.floor(this.tr-easury * (percentage / 100 + 1)) - this.treasury;
        }
    }
    return city;
}

solve('Tortuga',
    1000,
    10000);

