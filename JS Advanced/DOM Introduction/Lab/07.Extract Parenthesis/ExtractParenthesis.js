function extract(content) {
    let text = document.getElementById(content).textContent;
    let regExp = /\(([^)]+)\)/g;
    let matches = text.match(regExp);
    let result = [];
    for (const match of matches) {
        let word = match;
        result.push(word);
    }

    return result.join('; ');
}