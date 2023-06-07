import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import HeaderPrincipal from './HeaderPrincipal';
import Footer from '../../components/footer/Footer';
import Registro from './Registro';
import Inicio from './Inicio';
import axios from 'axios';



const Login = () => {
  const [register, setRegistrer] = useState(false);
  const navigate = useNavigate();


  const handleFormInicio = (data) => {
    axios.post('http://localhost:8087/estudiante/login', data).then((res) => {
      if (res.status === 200) {

        navigate('/home', { state: { loginData: data } });
      }
    }).catch(e=>{

      alert('Error iniciar: Correo no estudiantil o por favor registrate')
    })
  };

  const [data, setData]= useState(null)

  const handleFormRegistro = (Data) => {
    setData({
      ...data,
      Data
    })

    axios.post('http://localhost:8087/estudiante/agregar', data).then((res) => {
 
      setRegistrer(!register)
    });
  };

  const handleChangeForm = ()=>{
    setRegistrer(!register)
  }

  return (
    <>
      <HeaderPrincipal />
   
      {register === false && <Registro handleFormRegistro={handleFormRegistro} />}
      {register && <Inicio handleFormInicio={handleFormInicio} />}
      {register==false && <a className='opcionLogin' onClick={handleChangeForm}> Iniciar sesion </a>}
      {register==true && <a className='opcionLogin' onClick={handleChangeForm}> Registarse</a>}
      
      <Footer />
    </>
  );
};

export default Login;
