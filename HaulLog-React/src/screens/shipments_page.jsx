import React from "react";
import NavigationBar from '../components/navbar';
import CalendarComponent from '../components/CalendarComponent';
import './styles.css';
function LoginLandingPage() {
    return (
        <div>
            <NavigationBar/>
            <div className="login-landing-container">
                <CalendarComponent/>
            </div>
        </div>
    );
}

export default LoginLandingPage;