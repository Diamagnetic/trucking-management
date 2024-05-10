import React from "react";
import './styles.css';
import NavigationBar from '../components/navbar';
import CalendarComponent from '../components/CalendarComponent';


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