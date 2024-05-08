import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import NavigationBar from '../components/navbar'; // Import the NavigationBar component
import './styles.css';

const Signup = () => {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const [userId, setUserId] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [companyName, setCompanyName] = useState('');
  const [errors, setErrors] = useState({});

  const handleSignup = () => {
    let newErrors = {};

    if (!firstName.trim()) {
      newErrors.firstName = "First name is required.";
    }
    if (!lastName.trim()) {
      newErrors.lastName = "Last name is required.";
    }
    if (!email.trim()) {
      newErrors.email = "Email is required.";
    } else if (!email.match(/^[^@]+@\w+(\.\w+)+\w$/)) {
      newErrors.email = "Please enter a valid email address.";
    }
    if (!userId.trim()) {
      newErrors.userId = "User ID is required.";
    }
    if (!password.trim()) {
      newErrors.password = "Password is required.";
    } else if (password.length < 8 || !password.match(/[a-z]/i) || !password.match(/[0-9]/) || !password.match(/[\^$*.\[\]{}()?\-"!@#%&/\\,><':;|_~`]/)) {
      newErrors.password = "Password must be at least 8 characters long and include a number, a lowercase letter, an uppercase letter, and a special character.";
    }
    if (!confirmPassword.trim()) {
      newErrors.confirmPassword = "Confirm password is required.";
    } else if (password !== confirmPassword) {
      newErrors.confirmPassword = "Passwords do not match.";
    }
    if (!companyName.trim()) {
      newErrors.companyName = "Company name is required.";
    }

    setErrors(newErrors);

    if (Object.keys(newErrors).length === 0) {
      console.log('Signing up with:', firstName, lastName, email, userId, password, confirmPassword, companyName);
      // Proceed with additional signup logic here
    }
  };

  return (
    <div>
      <NavigationBar />
      <div className="form-container">
        <h2 style={{ color: '#2E0C6A', fontWeight: 'bold' }}>SIGN UP</h2>
        <input
          type="text"
          placeholder="First Name"
          value={firstName}
          onChange={(e) => setFirstName(e.target.value)}
        />
        {errors.firstName && <p className="error" style={{ color: 'red' }}>{errors.firstName}</p>}
        <input
          type="text"
          placeholder="Last Name"
          value={lastName}
          onChange={(e) => setLastName(e.target.value)}
        />
        {errors.lastName && <p className="error" style={{ color: 'red' }}>{errors.lastName}</p>}
        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        {errors.email && <p className="error" style={{ color: 'red' }}>{errors.email}</p>}
        <input
          type="text"
          placeholder="User ID"
          value={userId}
          onChange={(e) => setUserId(e.target.value)}
        />
        {errors.userId && <p className="error" style={{ color: 'red' }}>{errors.userId}</p>}
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        {errors.password && <p className="error" style={{ color: 'red' }}>{errors.password}</p>}
        <input
          type="password"
          placeholder="Confirm Password"
          value={confirmPassword}
          onChange={(e) => setConfirmPassword(e.target.value)}
        />
        {errors.confirmPassword && <p className="error" style={{ color: 'red' }}>{errors.confirmPassword}</p>}
        <input
          type="text"
          placeholder="Company Name"
          value={companyName}
          onChange={(e) => setCompanyName(e.target.value)}
        />
        {errors.companyName && <p className="error" style={{ color: 'red' }}>{errors.companyName}</p>}
        <button onClick={handleSignup}>Signup</button>
        <p style={{ color: 'black' }}>
          Already a Member? <Link to="/login">Login</Link> here!
        </p>
      </div>
    </div>
  );
};

export default Signup;
