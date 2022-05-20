function validate() {
    let inputElement = document.getElementById('email');

    const validateEmail = (email) => {
        return String(email)
          .toLowerCase()
          .match(
            /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
          );
      };
      
    const changeEventHandler = (e) => {
        if(!validateEmail(inputElement.value)) {
            e.target.classList.add('error');
        } else {
            e.target.classList.remove('error');
        }
    }
    inputElement.addEventListener('change', changeEventHandler);
}