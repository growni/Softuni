function solve(fruit, weightGrams, priceKilogram) {
    let money = weightGrams / 1000 * priceKilogram;
    let weightInKilo = weightGrams / 1000;
    console.log(`I need $${money.toFixed(2)} to buy ${weightInKilo.toFixed(2)} kilograms ${fruit}.`);
}
solve('orange', 2500, 1.80);
solve('apple', 1563, 2.35);