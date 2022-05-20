function attachGradientEvents() {
    let gradientElement = document.getElementById('gradient');
    let resultElement = document.getElementById('result');
    
    const mouseMoveEventHandler = (e) => {
        let percent = Math.floor(e.offsetX / (e.target.clientWidth - 1) * 100);
        resultElement.textContent = `${percent}%`
    }
    const mouseOutEventHandler = () => {
        resultElement.textContent = '';
    }

    gradientElement.addEventListener('mousemove', mouseMoveEventHandler);
    gradientElement.addEventListener('mouseout', mouseOutEventHandler);
}