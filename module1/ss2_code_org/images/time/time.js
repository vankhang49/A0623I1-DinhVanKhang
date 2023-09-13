const dayOfWeeks = ['sun', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'];
const $time = document.querySelector('.time');
const $date = document.querySelector('.date');

function padStart (value, length){
    return String(value).padStart(length, '0');
}

function update() {
    const now = new Date();
    const [
        hours, minutes, seconds,
        year, month, date, day,
    ] = [
        now.getHours(), now.getMinutes(), now.getSeconds(),
        now.getFullYear(), now.getMonth(),
        now.getDate(), now.getDay()
        ];

    $time.innerText = `${padStart(hours, 2)}:${padStart
    (minutes, 2)}:${padStart(seconds, 2)}`;
    $date.innerText = `${padStart(year, 4)}-${padStart
    (month + 1, 2)}-${padStart(date, 2)} ${dayOfWeeks[day]}`
}

update();
setInterval(update, 1000);