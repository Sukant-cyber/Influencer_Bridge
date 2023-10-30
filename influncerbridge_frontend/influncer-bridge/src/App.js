import './App.css';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import Home from './Pages/Home/Home';
import RegistrationForm from './Pages/LoginAndRegistration/Registration';

function App() {
  return (
    <div>
      <Router>
        <Routes>
        <Route exact path = '/' Component= { Home}></Route>
        <Route exact path = '/register' Component = { RegistrationForm}></Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
