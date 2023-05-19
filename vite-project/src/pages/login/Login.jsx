import React, { useState } from 'react'
import HeaderPrincipal from './HeaderPrincipal'
import Footer from '../../components/footer/Footer'
import Registro from './Registro'
import Inicio from './Inicio'
import axios from 'axios'
import { redirect } from "react-router-dom";


const Login = () => {
  const [register, setRegistrer] = useState(true);

  const handleFormInicio = (data) => {
    console.log(data)
    axios.post('http://localhost:8087/estudiante/login', data).then((res) => {
      if (res.status==200) {
        return redirect("/home");
      }
    })
  }

  const handleFormRegistro = (data) => {
    console.log(data)
    axios.post('http://localhost:8087/estudiante/agregar', data).then((res) => {
      console.log(res)
    })
  }

  return (
    <>
      <HeaderPrincipal />
      {
        register == false && (<Registro handleFormRegistro={handleFormRegistro} />)
      }
      {
        register && (<Inicio handleFormInicio={handleFormInicio} />)
      }

      <Footer />
    </>
  )
}

export default Login
