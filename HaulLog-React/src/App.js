// App.js

import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './screens/login'; // Adjust the path to import Login component
import Signup from './screens/signup'; // Adjust the path to import Signup component
import LandingPage from './screens/landing_page'; // Import the LandingPage component
import InvoicePage from './screens/invoice_page'; // Import the InvoicePage component
import LoginLandingPage from './screens/shipments_page';
import './App.css';

const App = () => {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route exact path="/" element={<LandingPage />} /> 
          <Route exact path="/login" element={<Login />} />
          <Route exact path="/signup" element={<Signup />} />
          <Route exact path="/invoice" element={<InvoicePage />} />
          <Route exact path="/landing" element={<LoginLandingPage/>} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
