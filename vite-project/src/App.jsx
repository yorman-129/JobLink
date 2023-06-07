import React from 'react'
import HomeUser from './pages/HomeUser'
import './App.css'
import { useLocation } from 'react-router-dom';

function App() {

    const location = useLocation();
    const loginData = location.state?.loginData;
    console.log(loginData,"app");
  return (
    <>
  
    <HomeUser data={loginData}/>

    </>
  )
}

export default App
