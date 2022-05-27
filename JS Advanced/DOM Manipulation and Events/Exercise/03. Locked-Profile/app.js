function lockedProfile() {
    //TODO: Fix this
    let profileElements = document.getElementsByClassName('profile');
    let buttonElements = Array.from(document.querySelectorAll('button'));
    let isClicked = false;
    const hideInfo = (e) => {
        let unlockRadioButtonElement = e.target.parentNode.children[4];
        let hiddenDiv = e.target.parentNode.children[9];
        let hideShowButtonElement = e.target.parentNode.children[10];
        if(unlockRadioButtonElement.checked) {
            hiddenDiv.style.display = 'none';
            hideShowButtonElement.textContent = 'Show more';
        }
    }
    const showMore = (e) => {
        let unlockRadioButtonElement = e.target.parentNode.children[4];
        let hiddenDiv = e.target.parentNode.children[9];
        let hideShowButtonElement = e.target.parentNode.children[10];
        
        if (unlockRadioButtonElement.checked) {
            hiddenDiv.style.display = 'block';
            hideShowButtonElement.textContent = 'Hide it';
            
            isClicked = true;
        }
        if(isClicked) {
            hideShowButtonElement.removeEventListener('click', showMore);
            hideShowButtonElement.addEventListener('click', hideInfo);
            isClicked = false;
        } else {
            hideShowButtonElement.removeEventListener('click', hideInfo);
            hideShowButtonElement.addEventListener('click', showMore);
        }
    }

    buttonElements.forEach(b => b.addEventListener('click', showMore));
    
}