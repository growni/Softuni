function solve() {
  let conventionInput = document.getElementById('naming-convention').value;
  let textInput = document.getElementById('text').value.toLowerCase();
  let splittedText = textInput.split(' ');
  switch (conventionInput) {
    case 'Camel Case':
      for (let i = 1; i < splittedText.length; i++) {
        let strSlice = splittedText[i].slice(1);
        splittedText[i] = splittedText[i].charAt(0).toUpperCase() + strSlice;
      }
      let camelResult = splittedText.join('');
      document.getElementById('result').textContent += camelResult;
      break;
    case 'Pascal Case':
      for (let i = 0; i < splittedText.length; i++) {
        let strSlice = splittedText[i].slice(1);
        splittedText[i] = splittedText[i].charAt(0).toUpperCase() + strSlice;
      }
      let pascalResult = splittedText.join('');
      document.getElementById('result').textContent += pascalResult;
      break;
      default: document.getElementById('result').textContent += 'Error!';
  }
}