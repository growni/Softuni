function deleteByEmail() {
    let inputElement = document.querySelector('input[name="email"]');
    let emailCells = document.querySelectorAll('tr td:nth-of-type(2)');
    let emailsArr = Array.from(emailCells);
    let targetElement = emailsArr.find(x => x.textContent == inputElement.value);
    if(targetElement) {
        document.getElementById('result').textContent = 'Deleted.';
        targetElement.parentNode.remove();
    } else {
        document.getElementById('result').textContent = 'Not found.'
    }
}