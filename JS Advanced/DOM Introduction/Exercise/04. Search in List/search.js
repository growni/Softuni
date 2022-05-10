function search() {
   let towns = document.getElementsByTagName('li');
   let input = document.getElementById('searchText').value;
   //clean setup
   for (const town of towns) {
      town.style.textDecoration = 'none';
      town.style.fontWeight = 'normal';
   }
   document.getElementById('result').textContent = '';
   //new search
   let matches = 0;
   for (const town of towns) {
      if(town.textContent.includes(input)) {
         town.style.textDecoration = 'underline';
         town.style.fontWeight = 'bold';
         matches++;
      }
   }
   document.getElementById('result').textContent = `${matches} matches found`
}
