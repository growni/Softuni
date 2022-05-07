function solve(array) {
    const food = {

    }
    let key = '';
    for (let f = 0; f < array.length; f++) {

        if (f % 2 == 0) {
            food[array[f]] = f;
            key = array[f];
        } else {
            let calories = array[f];
            food[key] = Number(calories);
        }
    }
    console.log(food);
}

solve(['Yoghurt', '48', 'Rise', '138', 'Apple', '52']);