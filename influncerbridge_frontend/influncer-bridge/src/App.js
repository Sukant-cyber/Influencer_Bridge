import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './Pages/Home/Home';
import RegistrationForm from './Pages/LoginAndRegistration/Registration';
import Login from './Pages/LoginAndRegistration/Login';
import AdminDashboard from './Pages/AdminDashboard/AdminDashboard';

function App() {
  return (
    <div>
      <Router>
        <Routes>
        <Route exact path = '/' Component= { Home}></Route>
        <Route exact path = '/register' Component = { RegistrationForm}></Route>
        <Route exact path = '/login' Component = { Login}></Route>
        <Route exact path = '/admindashboard' Component = { AdminDashboard}></Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
