function addItem() {
   let inputElement = document.getElementById('newItemText');
   let newLiElement = document.createElement('li');
   let deleteLinkElement = document.createElement('a');
   deleteLinkElement.href = '#';
   deleteLinkElement.textContent = '[Delete]';
   newLiElement.textContent = inputElement.value;
   let ulElement = document.getElementById('items');
   newLiElement.appendChild(deleteLinkElement);
   ulElement.appendChild(newLiElement);

   deleteLinkElement.addEventListener('click', () => {
        deleteLinkElement.parentNode.remove();
   });
}