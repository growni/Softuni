function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      //clean selected elements before re-click
      let selectedElements = document.querySelectorAll('.select');
      for (const element of selectedElements) {
         element.classList.remove('select');   
      }
      

      let searchWord = document.getElementById('searchField').value;
      document.getElementById('searchField').value = '';


      let data = document.querySelectorAll('tbody tr');
      for (let col = 0; col < data.length; col++) {
         let arr = data[col].getElementsByTagName('td');
         
         for (const singleElement of arr) {
            if(singleElement.textContent.includes(searchWord) && searchWord.length > 0) {
               data[col].classList.add('select');
            }
         }
      }
      selectedElements = document.getElementsByClassName('select');
   }
}