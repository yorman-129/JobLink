import React, { useEffect, useState } from 'react';
import HeaderHome from '../../components/headerHome/HeaderHome';
import Footer from '../../components/footer/Footer';
import MainProgreso from './mainProgreso';
import axios from 'axios';
import { useLocation, useParams } from 'react-router-dom';

const ProgresoRetos = () => {
  const location = useLocation();
  const loginData = location.state?.loginData;
  console.log(loginData);

  const { id } = useParams();
  const [retos, setReto] = useState(null);
  const url = `http://localhost:8087/retos/progreso/${id}`;
  console.log("path", url);

  useEffect(() => {
    axios.get(url).then(res => {
      setReto(res.data);
      console.log(res.data);
    });
  }, [id]); // Agregar "id" como dependencia

  return (
    <>
      <HeaderHome />
      <MainProgreso data={retos} />
      <Footer />
    </>
  );
};

export default ProgresoRetos;
