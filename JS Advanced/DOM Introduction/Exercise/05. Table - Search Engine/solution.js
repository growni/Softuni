function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);
   
   let COLUMNS = 3;
   function onClick() {
      let tbodyElements = document.getElementsByTagName('tbody');
      let tdElements = [];
     
      let tbodyElement = tbodyElements[0];
      let trElements = tbodyElement.getElementsByTagName('tr');
     
      for (const element of trElements) {
         tdElements.push(element);
      }
      let data = [];
      for (const tdElement of tdElements) {
         data.push(tdElement.getElementsByTagName('td'));
      }
      
      let searchWord = document.getElementById('searchField').value;
      document.getElementById('searchField').value = '';
      let selectedElements = document.getElementsByClassName('select');
      //clean selected elements before re-click
      for (const element of selectedElements) {
         element.classList.remove('select');
      }

      for(let row = 0; row < data.length; row++) {
         for(let col = 0; col < COLUMNS; col++) {
            if(data[row][col].textContent.includes(searchWord) && searchWord.length > 0) {
               let rowElement = data[row];
               for (const singleCol of rowElement) {
                  singleCol.classList.add('select');
               }
         
            }
            
         }
      }
      selectedElements = document.getElementsByClassName('select');
      
      
   }
}