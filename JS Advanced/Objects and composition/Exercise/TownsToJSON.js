function rectangle(array) {
    let data = [];
    let trimmedLine;
    for (const line of array) {
        trimmedLine = line.slice(2, line.length - 2);
        data.push(trimmedLine.split(' | '));
    }
    let output = [];
    for (let row = 1; row < data.length; row++) {
        let town = { Town: '', Latitude: 0, Longitude: 0 };
        town.Town = data[row][0];
        town.Latitude = +Number(data[row][1]).toFixed(2);
        town.Longitude = +Number(data[row][2]).toFixed(2);


        output.push(town)
    }
    console.log(JSON.stringify(output)); 7
}

rectangle(['| Town | Latitude | Longitude |',
    '| Veliko Turnovo | 43.0757 | 25.6172 |',
    '| Monatevideo | 34.50 | 56.11 |']);