// App.js

import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './screens/login'; // Adjust the path to import Login component
import Signup from './screens/signup'; // Adjust the path to import Signup component
import LandingPage from './screens/landing_page'; // Import the LandingPage component
import InvoicePage from './screens/invoice_page'; // Import the InvoicePage component
import './App.css';

const App = () => {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route exact path="/" element={<LandingPage />} /> {/* Define route for LandingPage */}
          <Route exact path="/login" element={<Login />} />
          <Route exact path="/signup" element={<Signup />} />
          <Route exact path="/invoice" element={<InvoicePage />} /> {/* Define route for InvoicePage */}
          {/* Add more routes here if needed */}
        </Routes>
      </div>
    </Router>
  );
};

export default App;
