function solve(array) {
    let data = [];
    for (const line of array) {
        let cleanedLine = '';
        let lineToChars = line.toChararray();
        for (const symbol of lineToChars) {
            if(symbol === '|') {
                lineToChars.splice(lineToChars.indexOf(symbol));
            }
        }
        cleanedLine = lineToChars.join();
        let dataLine = cleanedLine.split(/\s+/);
        data.push(dataLine);
    }
    let output = [];
    for(let row = 1; row < data.length; row++) {
        let town = {
            town: data[row][0],
            latitude: data[row][1],
            longtitude: data[row][2]
        }
        output.push(town)
    }
    console.log(JSON.stringify(output));
}

solve(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']);