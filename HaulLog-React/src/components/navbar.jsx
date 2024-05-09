// NavigationBar.jsx

import React , {useState} from 'react';
import { Link } from 'react-router-dom'; // Import Link for routing
import '../screens/styles.css';
import logo from '../Assets/logo.png'; // Import the logo image

const NavigationBar = () => {

  // Check to make sure user is logged in before showing Shipments and Generate Reports
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  return (
    <div className="navbar">
      <Link to='/' className='logo-link'>
        <img src={logo} alt="Logo" className="logo" />
      </Link>
      
      <div className="nav-links">
        {
          isLoggedIn && (
            <>
            <Link to="/landing" className="nav-item">Shipments</Link>
            <span className="nav-item">&nbsp;</span>
            <Link to="/reports" className="nav-item">Generate Reports</Link>
            </>
          )
        }
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
