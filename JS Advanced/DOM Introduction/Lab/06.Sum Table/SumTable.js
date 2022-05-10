function sumTable() {
    let values = document.getElementsByTagName('td');
    let sum = 0;
    for (const value of values) {
        if(!isNaN(value.textContent)) {
            sum += Number(value.textContent);
        }
    }
    document.getElementById('sum').textContent = sum;
}