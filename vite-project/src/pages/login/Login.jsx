import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import HeaderPrincipal from './HeaderPrincipal';
import Footer from '../../components/footer/Footer';
import Registro from './Registro';
import Inicio from './Inicio';
import axios from 'axios';

const Login = () => {
  const [register, setRegistrer] = useState(true);
  const navigate = useNavigate();

  const handleFormInicio = (data) => {
    console.log(data);
    axios.post('http://localhost:8087/estudiante/login', data).then((res) => {
      if (res.status === 200) {
        navigate('/home');
      }
    });
  };

  const handleFormRegistro = (data) => {
    console.log(data);
    axios.post('http://localhost:8087/estudiante/agregar', data).then((res) => {
      console.log(res);
    });
  };

  return (
    <>
      <HeaderPrincipal />
      {register === false && <Registro handleFormRegistro={handleFormRegistro} />}
      {register && <Inicio handleFormInicio={handleFormInicio} />}
      <Footer />
    </>
  );
};

export default Login;
