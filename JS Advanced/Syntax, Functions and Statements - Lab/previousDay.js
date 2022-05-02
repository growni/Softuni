function previousDay(year, month, day) {
    const today = new Date(year, month, day);
    const yesterday = new Date(today);
    yesterday.setDate(yesterday.getDate() - 1);
    console.log(yesterday.getFullYear() + '-' + yesterday.getMonth() + '-' + yesterday.getDate());
}
previousDay(2016, 9, 30);
previousDay(2016, 10, 1);
previousDay(2016, 12, 1);