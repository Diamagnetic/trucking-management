import React from "react";
import CalendarComponent from '../components/CalendarComponent';
import NavigationBar from '../components/navbar';
import './styles.css';

function LoginLandingPage() {
    return (
        <div>
            <NavigationBar/>
            <div className="login-landing-container">
            <h1>Welcome User</h1>
            <CalendarComponent/>
        </div>
        </div>
    );
}

export default LoginLandingPage;