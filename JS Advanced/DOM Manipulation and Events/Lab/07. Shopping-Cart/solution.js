function solve() {
   let addButtonElements = document.querySelectorAll('button[class="add-product"]');
   let textAreaElement = document.querySelector('textarea');
   let totalPrice = 0;
   let productsArr = [];
   //Add buttons
   const addProductEventHandler = (e) => {
      let productName = Array.from(e.target.parentNode.parentNode.children)[1].children[0].textContent;
      let productPrice = Array.from(e.target.parentNode.parentNode.children)[3].textContent;
      
     textAreaElement.textContent += `Added ${productName} for ${productPrice} to the cart.\n`
      totalPrice += +productPrice;
      productsArr.push(productName);
   }
   for (const addButton of addButtonElements) {
      addButton.addEventListener('click',addProductEventHandler);
   }
   
   //Checkout button
   let checkoutButtonElement = document.getElementsByClassName('checkout')[0];

   const checkoutEventHandler = (e) => {
      textAreaElement.textContent += 'You bought ' + productsArr.join(', ') + ` for ${totalPrice.toFixed(2)}.`;
      let buttonElements = Array.from(document.querySelectorAll('button'));
      buttonElements.forEach(b => b.disabled = true);
   }

   checkoutButtonElement.addEventListener('click',checkoutEventHandler);

}