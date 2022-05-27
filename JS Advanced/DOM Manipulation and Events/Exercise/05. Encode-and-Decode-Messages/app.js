function encodeAndDecodeMessages() {
    let mainDivElements = document.querySelectorAll('main div');
    let encodeTextAreaElement = mainDivElements[0].children[1];
    let decodeTextAreaElement = mainDivElements[1].children[1];
    let encodeButtonElement = mainDivElements[0].children[2];
    let decodeButtonElement = mainDivElements[1].children[2];
    
    const encodeEvent = () => {
        let encodedMessage = '';
        decodeTextAreaElement.value = '';
        let splittedMessageForEncoding = encodeTextAreaElement.value.split('');
        for (const char of splittedMessageForEncoding) {
            encodedMessage += String.fromCharCode(char.charCodeAt(0) + 1);
        }
        decodeTextAreaElement.value = encodedMessage;
        encodeTextAreaElement.value = '';
        
    }
    
    const decodeEvent = () => {
        
        let decodedMessage = '';
        let splittedMessageForDecoding = decodeTextAreaElement.value.split('');
        for (const char of splittedMessageForDecoding) {
            decodedMessage += String.fromCharCode(char.charCodeAt(0) - 1);
        }
        decodeTextAreaElement.value = decodedMessage;
        
    }
    encodeButtonElement.addEventListener('click', encodeEvent);
    decodeButtonElement.addEventListener('click', decodeEvent);
}