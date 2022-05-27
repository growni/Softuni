function create(words) {
   const displayDivEventHandler = (e) => {
      let pElement = e.target.children[0];
      
      if(pElement.style.display = "none") {
         pElement.style.display = "block";
      } 
   }
   for (const element of words) {
      
         let pElement = document.createElement('p');
         pElement.textContent = element;
         let divElement = document.createElement('div');
         divElement.appendChild(pElement);
         divElement.addEventListener('click', displayDivEventHandler)
         let contentElemenet = document.getElementById('content');
         contentElemenet.appendChild(divElement);
    
   }
   
}