import React, { useState, useEffect } from 'react'
import axios from 'axios';
import CardReto from '../retos/CardReto';
import './mainHome.css';

const MainHome = ({data}) => {
  const [retos, setReto]=useState([{}]) 
  useEffect(() => {
    axios.get('http://localhost:8087/retos/all')
      .then(res => {
        setReto(res.data);
      });
  }, []);


  const handleReto = (event) => {
    
  }

  return (
    <>
      <main className='container-main'> 
        <section className='container-section'>
          <h2>Bienvenido a la Plataforma de Retos.</h2>
          <p>Esta es una plataforma donde podrás encontrar retos proporcionados por empresas del Oriente Antioqueño. Completa los retos y recibe una certificación de experiencia. </p>
        </section>
        <section className='container-section'>
          <h3>Últimos Retos</h3>
          <ul className='retos'>
            
            {retos.map((reto) =>{
             
              return <CardReto data={data} description={reto.descripcion} dificultad={reto.dificultad} empresa={reto.empresa} id={reto.id} onClick={handleReto}/>
            })} 
         
            
          </ul>
        </section>
      </main>
    </>
  )
}

export default MainHome
