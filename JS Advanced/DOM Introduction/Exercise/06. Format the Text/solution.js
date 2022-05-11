function solve() {
  //TODO task is not finished
  let inputElement = document.getElementById('input');
  let sentances = inputElement.value.split('.');
  let outputElement = document.getElementById('output');
  let counter = 0;
  for (let i = 0; i < sentances.length; ++i) {
    if (counter % 3 == 0) {
      outputElement.innerHTML += `<p> ${sentances[i]}.</p>`;
       
    } else {
      let paraELement = document.querySelectorAll('div p');
      if(i != sentances.length - 1) {
        paraELement[paraELement.length - 1].textContent += `${sentances[i]}.` ;
      } else {
        paraELement[paraELement.length - 1].textContent += `${sentances[i]}` ;
      }
    }
    counter++;
  }
}