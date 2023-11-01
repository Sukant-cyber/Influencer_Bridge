import React, { useState } from 'react';
import './LoginStyle.css'; // Import your CSS file
import registrationServiceInstance from '../../Service/RegistrationService';
import { useNavigate } from 'react-router-dom';
import Navbar from '../../Components/Navbar/Navbar';

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleEmailChange = (event) => setEmail(event.target.value);
  const handlePasswordChange = (event) => setPassword(event.target.value);

  const navigate = useNavigate();

  const navigateTo = (path) => {
    navigate(path)
  }

  const handleLogin = async (event) => {
    event.preventDefault();

    const loginData = {
      email,
      password,
    };

    try {
      const response = await registrationServiceInstance.loginUser(loginData);

      console.log('Login successful:', response);

      navigateTo('/admindashboard')

      setEmail('');
      setPassword('');
    } catch (error) {
      console.error('Login failed:', error);
    }
  };

  return (
    <div>
         <Navbar/>
    <div className="login-page">
      <div className="login-container">
        <h1>Login Form</h1>
        <form onSubmit={handleLogin} className="login-form">
          <div className="form-group">
            <label>Email</label>
            <input
              type="email"
              name="email"
              value={email}
              onChange={handleEmailChange}
              required
            />
          </div>
          <div className="form-group">
            <label>Password</label>
            <input
              type="password"
              name="password"
              value={password}
              onChange={handlePasswordChange}
              required
            />
          </div>
          <div className="form-group">
            <button className="login-button" type="submit">
              Login
            </button>
          </div>
          <div className="form-group">
            <p className="register-link">
              Don't have an account? <span onClick={() => navigateTo('/register')} className='register-link-name' >Register here</span>
            </p>
          </div>
        </form>
      </div>
    </div>
    </div>
  );
}

export default Login;
