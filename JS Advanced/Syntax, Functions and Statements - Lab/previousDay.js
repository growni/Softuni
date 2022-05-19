function previousDay(year, month, day) {
    const today = new Date(year, month -1, day);
    const yesterday = new Date(today);
    yesterday.setDate(yesterday.getDate() - 1);
    console.log(yesterday.getFullYear() + '-' + (Number(yesterday.getMonth() + 1)) + '-' + yesterday.getDate());
}
previousDay(2016, 9, 30);
previousDay(2016, 10, 1);
previousDay(2016, 12, 1);