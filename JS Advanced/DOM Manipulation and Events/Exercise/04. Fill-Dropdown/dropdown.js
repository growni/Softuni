function addItem() {
    let inputText = document.getElementById('newItemText');
    let inputValue = document.getElementById('newItemValue');
    
    let newOption = document.createElement('option');
    newOption.text = inputText.value;
    newOption.value = inputValue.value;
    
    let dropdownMenu = document.getElementById('menu');
    dropdownMenu.appendChild(newOption);
    inputText.value = '';
    inputValue.value = '';
}