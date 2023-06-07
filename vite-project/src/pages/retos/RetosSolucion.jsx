import React, { useState, useEffect } from 'react'
import axios from 'axios';
import { useParams } from 'react-router-dom';
import HeaderRetos from './components/HeaderRetos';
import MainRetos from './components/MainRetos';
import Footer from '../../components/footer/Footer'
import { useLocation } from 'react-router-dom';


const RetosSolucion = () => {
  const location = useLocation();
  const loginData = location.state?.loginData;
  console.log(loginData,"retos-solucion");
  const [reto, setReto] = useState([{}]);
  const { id } = useParams();
  const url = `http://localhost:8087/retos/find/${id}`;

  useEffect(() => {
    axios.get(url)
      .then(res => {
        setReto(res.data);
      });
  }, []);


  return (
    <>
      <HeaderRetos data={reto} />
      <MainRetos data={reto} mail={loginData}/>
      <Footer />
    </>
  )
}

export default RetosSolucion
