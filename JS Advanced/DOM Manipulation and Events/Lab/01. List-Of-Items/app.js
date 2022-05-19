function addItem() {
    let ulElement = document.getElementById('items');
    let liElement = document.createElement('li');
    let input = document.getElementById('newItemText').value;
    liElement.textContent = input;
    ulElement.appendChild(liElement);
}