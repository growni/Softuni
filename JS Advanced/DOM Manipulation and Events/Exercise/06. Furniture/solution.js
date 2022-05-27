function solve() {

  let generateButtonElement = document.getElementById('exercise').children[2];
  let generateTextareaElement = document.getElementById('exercise').children[1];
  const generateFurniture = () => {
    let furnitureData = Array.from(JSON.parse(generateTextareaElement.value));
    let rowToClone = document.querySelectorAll('tbody tr')[0];
    let tBody = rowToClone.parentNode;
    //start by cloning the already existing row
    
    for (const furniture of furnitureData) {
      let clonedRow = rowToClone.cloneNode(true);
      //first change the old img with the new one
      let newImgElement = document.createElement('img');
      newImgElement.src = furniture.img;
      let oldImgElement = clonedRow.children[0].children[0];
      clonedRow.children[0].removeChild(oldImgElement);
      clonedRow.children[0].append(newImgElement);
      //change the product name
      clonedRow.children[1].children[0].textContent = furniture.name;
      //change the price
      clonedRow.children[2].children[0].textContent = furniture.price;
      //change the decoration factor
      clonedRow.children[3].children[0].textContent = furniture.decFactor;
      tBody.append(clonedRow);
      
      
    }
    
  }

  generateButtonElement.addEventListener('click', generateFurniture);
}