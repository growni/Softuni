
function printText() {
    let ulElement = document.getElementById('items');
    let items = Array.from(ulElement.children);
    const result = items.map(e => e.textContent).join('\n');
    console.log(items);
    let textAreaElement = document.getElementById('result');
    textAreaElement.value = result;
};
