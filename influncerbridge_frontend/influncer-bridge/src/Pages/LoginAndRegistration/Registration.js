import React, { useState } from 'react';
import './RegistrationStyle.css'
import registrationServiceInstance from '../../Service/RegistrationService';
import { useNavigate } from 'react-router-dom';
import Navbar from '../../Components/Navbar/Navbar';

function RegistrationForm() {

  const navigate = useNavigate();

  const navigateTo = (path) => {
    navigate(path)
  }

  
  const [firstName, setFirstName] = useState('');
  const [middleName, setMiddleName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const [faceBook, setFaceBook] = useState('');
  const [instagram, setInstagram] = useState('');
  const [twitter, setTwitter] = useState('');
  const [youtube, setYoutube] = useState('');
  const [othersSocialMediaLink, setOthersSocialMediaLink] = useState('');
  const [occupation, setOccupation] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');
  const [dob, setDob] = useState('');
  const [address, setAddress] = useState('');
  const [password, setPassword] = useState('');

  const occupationOptions = [
    "Agriculture",
    "Business",
    "Education",
    "Finance",
    "Healthcare",
    "Information Technology",
    "Manufacturing",
    "Retail",
    "Service Industry",
    "Student",
    "Transportation",
    "Unemployed",
    "Other"
  ];

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    switch (name) {
      case 'firstName':
        setFirstName(value);
        break;
      case 'middleName':
        setMiddleName(value);
        break;
      case 'lastName':
        setLastName(value);
        break;
      case 'email':
        setEmail(value);
        break;
      case 'faceBook':
        setFaceBook(value);
        break;
      case 'instagram':
        setInstagram(value);
        break;
      case 'twitter':
        setTwitter(value);
        break;
      case 'youtube':
        setYoutube(value);
        break;
      case 'othersSocialMediaLink':
        setOthersSocialMediaLink(value);
        break;
      case 'occupation':
        setOccupation(value);
        break;
      case 'phoneNumber':
        setPhoneNumber(value);
        break;
      case 'dob':
        setDob(value);
        break;
      case 'address':
        setAddress(value);
        break;
      case 'password':
        setPassword(value);
        break;
      default:
        break;
    }
  };

  const handleRegistration = async (event) => {
    event.preventDefault();

    const registrationData = {
      firstName,
      middleName,
      lastName,
      email,
      faceBook,
      instagram,
      twitter,
      youtube,
      othersSocialMediaLink,
      occupation,
      phoneNumber,
      dob,
      address,
      password,
    };

    try {
      const response = await registrationServiceInstance.saveUser(registrationData);
      console.log('Registration successful:', response);

      navigateTo('/login')

      // Reset the form fields after successful registration
      setFirstName('');
      setMiddleName('');
      setLastName('');
      setEmail('');
      setFaceBook('');
      setInstagram('');
      setTwitter('');
      setYoutube('');
      setOthersSocialMediaLink('');
      setOccupation('');
      setPhoneNumber('');
      setDob('');
      setAddress('');
      setPassword('');
    } catch (error) {
      console.error('Registration failed:', error);
    }
  };

  return (
    <div>
      <Navbar/>
    <div className="registration-page">
    <div className="registration-container">
      <h1>Registration Form</h1>
      <form onSubmit={handleRegistration} className="registration-form">
        <div className='form-row'>
        <div className="form-group">
          <label>First Name</label>
          <input
            type="text"
            name="firstName"
            value={firstName}
            onChange={handleInputChange}
          />
        </div>
        <div className="form-group">
          <label>Middle Name</label>
          <input
            type="text"
            name="middleName"
            value={middleName}
            onChange={handleInputChange}
          />
        </div>
        <div className="form-group">
          <label>Last Name</label>
          <input
            type="text"
            name="lastName"
            value={lastName}
            onChange={handleInputChange}
          />
          </div>
        </div>
        <div className='form-row'>
        <div className="form-group">
          <label>Email</label>
          <input
            type="email"
            name="email"
            value={email}
            onChange={handleInputChange}
          />
        </div>
        <div className="form-group">
          <label>Facebook</label>
          <input
            type="text"
            name="faceBook"
            value={faceBook}
            onChange={handleInputChange}
          />
        </div>
        <div className="form-group">
          <label>Instagram</label>
          <input
            type="text"
            name="instagram"
            value={instagram}
            onChange={handleInputChange}
          />
          </div>
        </div>
        <div className='form-row'>
        <div className="form-group">
          <label>Twitter</label>
          <input
            type="text"
            name="twitter"
            value={twitter}
            onChange={handleInputChange}
          />
        </div>
        <div className="form-group">
          <label>YouTube</label>
          <input
            type="text"
            name="youtube"
            value={youtube}
            onChange={handleInputChange}
          />
        </div>
        <div className="form-group">
          <label>Other Social Media Link</label>
          <input
            type="text"
            name="othersSocialMediaLink"
            value={othersSocialMediaLink}
            onChange={handleInputChange}
          />
          </div>
        </div>
        <div className='form-row'>
        <div className="form-group">
          <label>Occupation</label>
          <select
            name="occupation"
            value={occupation}
            onChange={handleInputChange}
          >
            <option value="">Select Occupation</option>
            {occupationOptions.map((option, index) => (
              <option key={index} value={option}>
                {option}
              </option>
            ))}
          </select>
        </div>
        <div className="form-group">
          <label>Phone Number</label>
          <input
            type="text"
            name="phoneNumber"
            value={phoneNumber}
            onChange={handleInputChange}
          />
        </div>
        <div className="form-group">
          <label>Date of Birth</label>
          <input
            type="text"
            name="dob"
            value={dob}
            onChange={handleInputChange}
          />
          </div>
        </div>
        <div className='form-row'>
        <div className="form-group">
          <label>Address</label>
          <input
            type="text"
            name="address"
            value={address}
            onChange={handleInputChange}
          />
        </div>
        <div className="form-group">
          <label>Password</label>
          <input
            type="password"
            name="password"
            value={password}
            onChange={handleInputChange}
          />
          </div>
        </div>
        <div className="form-group">
          <button className='Register-button' type="submit">Register</button>
        </div>
        <div className="form-group">
            <p className="login-link">
               Already have an account? <span onClick={() => navigateTo('/login')} className='login-link-name' > Login here</span>
            </p>
          </div>
      </form>
    </div>
  </div>
  </div>
  );
}

export default RegistrationForm;
