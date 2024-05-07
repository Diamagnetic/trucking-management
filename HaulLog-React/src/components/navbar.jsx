// NavigationBar.jsx

import React from 'react';
import { Link } from 'react-router-dom'; // Import Link for routing
import '../screens/styles.css';
import logo from '../Assets/logo.png'; // Import the logo image

const NavigationBar = () => {
  return (
    <div className="navbar">
      <img src={logo} alt="Logo" className="logo" />
      <div className="nav-links">
        {/* Replace Blog and Contact with Shipment ID and Generate Reports */}
        <Link to="/shipment" className="nav-item">Shipment ID</Link>
        <span className="nav-item">&nbsp;</span>
        <Link to="/reports" className="nav-item">Generate Reports</Link>
      </div>
      <div className="login-signup-links">
        <Link to="/login" className="nav-item">Login</Link>
        <span className="nav-item"> | </span>
        <Link to="/signup" className="nav-item">Signup</Link>
      </div>
    </div>
  );
};

export default NavigationBar;
