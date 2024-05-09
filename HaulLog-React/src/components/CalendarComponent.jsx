import React from "react";
import { useState } from "react";
import Calendar from "react-calendar";
import 'react-calendar/dist/Calendar.css';
import './components.css';

function CalendarComponent() {
    const [date,setDate] = useState(new Date());

    return (
        <div className='react-calendar'>
            <Calendar onChange={setDate} value={date} />
        <p className='text-center'>
            <span className='bold'>Selected Date:</span>{' '}
            {date.toDateString()}
        </p>
        </div>
    );
}

export default CalendarComponent;