function focused() {
    let sectionElements = document.querySelectorAll('input[type="text"]');
    
    const focusEventHandler = (e) => {
        e.target.parentNode.classList.add("focused");
    }
    const blurEventHandler = (e) => {
        e.target.parentNode.classList.remove("focused");
    }

    for (const element of sectionElements) {
        element.addEventListener('focus',focusEventHandler);
        element.addEventListener('blur',blurEventHandler);
    }
}