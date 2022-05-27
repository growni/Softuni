function attachEventsListeners() {

    let daysButtonElement = document.getElementById('daysBtn');
    let hoursButtonElement = document.getElementById('hoursBtn');
    let minutesButtonElement = document.getElementById('minutesBtn');
    let secondsButtonElement = document.getElementById('secondsBtn');

    let daysInput = document.getElementById('days');
    let hoursInput = document.getElementById('hours');
    let minutesInput = document.getElementById('minutes');
    let secondsInput = document.getElementById('seconds');
    const convertDays = () => {
        hoursInput.value = daysInput.value * 24;
        minutesInput.value = hoursInput.value * 60;
        secondsInput.value = minutesInput.value * 60;
    }
    const convertHours = () => {
        daysInput.value = hoursInput.value / 24;
        minutesInput.value = hoursInput.value * 60;
        secondsInput.value = minutesInput.value * 60;
    }
    const convertMinutes = () => {
        hoursInput.value = minutesInput.value / 60;
        daysInput.value = hoursInput.value / 24;
        secondsInput.value = minutesInput.value * 60;
    }
    const convertSeconds = () => {
        minutesInput.value = secondsInput.value / 60;
        hoursInput.value = minutesInput.value / 60;
        daysInput.value = hoursInput.value / 24;
    }

    daysButtonElement.addEventListener('click' ,convertDays);
    hoursButtonElement.addEventListener('click', convertHours);
    minutesButtonElement.addEventListener('click', convertMinutes);
    secondsButtonElement.addEventListener('click', convertSeconds);
}