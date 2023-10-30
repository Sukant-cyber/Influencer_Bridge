import axios from "axios";

const REGISTRATION_BASE_REST_API_URL = 'http://localhost:8080/users'

class RegistrationService{

    saveUser(user){
        return axios.post(`${REGISTRATION_BASE_REST_API_URL}/save`, user);
    }

    loginUser(loginData){
        return axios.post(`${ REGISTRATION_BASE_REST_API_URL}/login`, loginData);
    }

    getAllRegistrations() {
        return axios.get(`${REGISTRATION_BASE_REST_API_URL}/getAllUsers`);
    }

    getUserByEmail(email) {
        return axios.get(`${REGISTRATION_BASE_REST_API_URL}/getUser/${email}`);
    }
}

const registrationServiceInstance = new RegistrationService();

export default registrationServiceInstance;