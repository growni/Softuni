function colorize() {
    let tableElements = document.getElementById('table').getElementsByTagName('tr');
    for(let item = 0; item < tableElements.length; item++) {
        if(item % 2 != 0) {
            tableElements[item].style.backgroundColor = 'teal';
        }
    }
}